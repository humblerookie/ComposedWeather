package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.anvith.weather.entities.IntraDayForecast

/**
 * Created by anvith on 18/11/20.
 */


@Composable
fun HumidityTimeline(
    modifier: Modifier = Modifier,
    forecasts: List<IntraDayForecast>
) {

    Row(modifier = modifier.padding(top = 36.dp).fillMaxWidth(1f)) {
        forecasts.forEachIndexed { index, intraDayForecast ->
            HumidityInfo(humidity = intraDayForecast.humidity, time = intraDayForecast.time)
            if (index != forecasts.size - 1) {
                Spacer(modifier = modifier.preferredSize(16.dp))
            }
        }
    }

}

@Composable
fun HumidityInfo(
    modifier: Modifier = Modifier,
    humidity: Int,
    time: String
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            DropletImage(fillPercent = humidity, modifier = modifier.height(18.dp))
            Spacer(modifier = modifier.size(4.dp))
            Text(
                text = "$humidity%",
                style = MaterialTheme.typography.caption,
                modifier = modifier.align(Alignment.Bottom)
            )
        }
        Spacer(modifier = modifier.height(4.dp))
        Text(
            text = time,
            style = MaterialTheme.typography.body2,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }

}
