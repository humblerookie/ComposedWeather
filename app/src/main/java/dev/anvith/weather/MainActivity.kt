package dev.anvith.weather

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradient
import androidx.compose.ui.graphics.VerticalGradient
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.MutableLiveData
import androidx.ui.tooling.preview.Preview
import dev.anvith.weather.entities.Weather
import dev.anvith.weather.extensions.PERIOD.*
import dev.anvith.weather.extensions.period
import dev.anvith.weather.extensions.transitionColor
import dev.anvith.weather.providers.WeatherDataProvider
import dev.anvith.weather.ui.*
import dev.anvith.weather.ui.compose.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val animStream = MutableLiveData(0f)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Sunrise is percentage 0f

        setContent {

            val animPercentage: Float by animStream.observeAsState(0f)
            WeatherTheme {
                MainSurface(animPercentage, WeatherDataProvider())
            }
            initAnimation(animStream)
        }
    }

    private fun initAnimation(animStream: MutableLiveData<Float>) {
        with(Handler(Looper.getMainLooper())) {
            for (i in 1..100) {
                postDelayed({
                    animStream.value = i / 100f
                }, i * 100L)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherTheme {
        MainSurface(0.3f, WeatherDataProvider())
    }
}


@Composable()
fun MainSurface(percentage: Float, weatherDataProvider: WeatherDataProvider) {
    Surface(color = Color.White) {
        val weather = weatherDataProvider.getWeather()
        WeatherScreen(percentage = percentage, weather = weather)
    }

}

@Composable
fun WeatherScreen(modifier: Modifier = Modifier, percentage: Float, weather: Weather) {

    Box(
        modifier = modifier
            .fillMaxSize(1f)
    ) {
        ConstraintLayout(modifier = modifier.matchParentSize()) {
            Sky(modifier = modifier.fillMaxSize(), animPercentage = percentage, numStars = 10)
            val (fiveDayForecast, windSpeed, humidity, divider1, divider2, metaInfo) = createRefs()
            val mainGuide = createGuidelineFromTop(0.45f)
            Moon(animPercentage = percentage)
            Sun(animPercentage = percentage)
            Mountain(mainGuide = mainGuide, animPercentage = percentage)
            Trees(mainGuide = mainGuide, animPercentage = percentage)
            CurrentWeather(animPercentage = percentage, weather = weather, mainGuide = mainGuide)
            FiveDayWeather(weather = weather, mainGuide = mainGuide, ref = fiveDayForecast)
            HorizontalDivider(selfRef = divider1, topRef = fiveDayForecast, bottomRef = windSpeed)
            WindSpeed(modifier = modifier.constrainAs(windSpeed) {
                linkTo(top = divider1.bottom, bottom = humidity.top)
                start.linkTo(divider1.start)
            }, windSpeed = weather.windSpeed)
            HumidityTimeline(modifier = modifier.constrainAs(humidity) {
                linkTo(top = windSpeed.bottom, bottom = divider2.top)
                start.linkTo(divider1.start)
            }, weather.fiveDayForecast.first().intraDayVariance)
            HorizontalDivider(selfRef = divider2, topRef = humidity, bottomRef = metaInfo)
            MetaInfo(modifier.constrainAs(metaInfo) {
                linkTo(top = divider2.bottom, bottom = parent.bottom)
                linkTo(start = divider2.start, end = divider2.end)
            }.fillMaxWidth(0.8f), weather = weather)
        }
    }
}

fun getGradient(percentage: Float): Array<Pair<Float, Color>> {
    return when (percentage.period()) {
        MORNING -> morningGradient.toTypedArray()
        AFTERNOON -> afternoonGradient.toTypedArray()
        NIGHT -> nightGradient.toTypedArray()
    }
}


@Composable
fun Sky(
    modifier: Modifier = Modifier,
    animPercentage: Float,
    numStars: Int = 1
) {
    Canvas(modifier = modifier) {
        //Draw Background
        val gradient = getGradient(animPercentage)
        drawRect(
            brush = VerticalGradient(
                *gradient,
                startY = 0f,
                endY = size.height
            )
        )
        //Draw Stars
        val w = size.width.toInt()
        val h = size.height.toInt() / 3
        repeat(numStars) {
            val x = Random.nextInt(0, w)
            val y = Random.nextInt(0, h)
            val radius = Random.nextInt(3, 10)
            val color = starsColor.transitionColor(animPercentage).run {
                copy(alpha = alpha * alpha)
            }
            val brush = RadialGradient(listOf(color.copy(0.5f), color), 0.5f, 0.5f, 0.5f)
            drawCircle(
                brush = brush,
                center = Offset(x = x.toFloat(), y = y.toFloat()),
                radius = radius.toFloat()
            )
        }
    }


}



