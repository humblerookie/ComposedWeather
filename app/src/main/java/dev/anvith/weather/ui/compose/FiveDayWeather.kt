package dev.anvith.weather.ui.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.anvith.weather.entities.Forecast
import dev.anvith.weather.entities.Weather
import dev.anvith.weather.extensions.toDrawable

/**
 * Created by anvith on 18/11/20.
 */


@Composable
fun ConstraintLayoutScope.FiveDayWeather(
    modifier: Modifier = Modifier,
    weather: Weather,
    mainGuide: ConstraintLayoutBaseScope.HorizontalAnchor,
    ref: ConstrainedLayoutReference
) {

    Row(modifier = modifier.constrainAs(ref) {
        top.linkTo(mainGuide)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }.padding(vertical = 16.dp)) {
        weather.fiveDayForecast.forEachIndexed { index, forecast ->
            DailyForecast(forecast = forecast)
            if (index != weather.fiveDayForecast.size - 1) {
                Spacer(modifier = modifier.preferredSize(16.dp))
            }
        }
    }
}

@Composable
fun DailyForecast(modifier: Modifier = Modifier, forecast: Forecast) {

    Column (){
        Text(
            text = forecast.day,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally),
            style = MaterialTheme.typography.body1,
        )
        VectorImage(resId = forecast.type.toDrawable(), modifier = modifier.size(32.dp).align(alignment = Alignment.CenterHorizontally),)
        Text(
            text = forecast.temperature,
            style = MaterialTheme.typography.body1,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally),
        )
    }
}