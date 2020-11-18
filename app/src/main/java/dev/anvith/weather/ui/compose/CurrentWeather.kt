package dev.anvith.weather.ui.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.anvith.weather.entities.Weather
import dev.anvith.weather.extensions.transitionColor
import dev.anvith.weather.ui.weatherTextColor
import java.util.*

/**
 * Created by anvith on 18/11/20.
 */

@Composable
fun ConstraintLayoutScope.CurrentWeather(
    modifier: Modifier = Modifier,
    animPercentage: Float,
    mainGuide:ConstraintLayoutBaseScope.HorizontalAnchor,
    weather: Weather,
) {
    val (temperature, location,time) = createRefs()
    val horizontalEnd = createGuidelineFromStart(0.9f)
    Text(
        text = weather.temperature,
        style = MaterialTheme.typography.h1,
        color = weatherTextColor.transitionColor(animPercentage),
        modifier = modifier.constrainAs(temperature){
            linkTo(top = parent.top, bottom = mainGuide,bias = 0.6f)
            start.linkTo(location.start)
        }
    )
    Text(
        text = weather.currentTime,
        style = MaterialTheme.typography.h6,
        color = weatherTextColor.transitionColor(animPercentage),
        modifier = modifier.constrainAs(time){
            end.linkTo(horizontalEnd)
            top.linkTo(temperature.bottom)
        }
    )
    Text(
        text = weather.location.toUpperCase(Locale.getDefault()),
        style = MaterialTheme.typography.h6,
        color = weatherTextColor.transitionColor(animPercentage),
        modifier = modifier.constrainAs(location){
            baseline.linkTo(time.baseline)
            end.linkTo(time.start)
        }.padding(end = 8.dp)
    )
}