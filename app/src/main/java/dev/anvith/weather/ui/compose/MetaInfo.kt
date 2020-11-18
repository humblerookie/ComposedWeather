package dev.anvith.weather.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.unit.dp
import dev.anvith.weather.entities.Weather

/**
 * Created by anvith on 18/11/20.
 */
@Composable
fun MetaInfo(
    modifier: Modifier = Modifier,
    weather: Weather,
) {
    Row(modifier = modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
        Column (modifier = modifier.background(color = Color.Black)){
            Text(text = "Sunrise", style = MaterialTheme.typography.caption,)
            Text(text = weather.sunrise, style = MaterialTheme.typography.h4,)
            Spacer(modifier = modifier.height(16.dp))
            Text(text = "Visibility", style = MaterialTheme.typography.caption,)
            Text(text = weather.visibility, style = MaterialTheme.typography.h4,)
        }
        Column (modifier = modifier.background(color = Color.Red)){
            Text(text = "Sunset", style = MaterialTheme.typography.caption,)
            Text(text = weather.sunset, style = MaterialTheme.typography.h4,)
            Spacer(modifier = modifier.height(16.dp))
            Text(text = "UV Index", style = MaterialTheme.typography.caption,)
            Text(text = weather.uvIndex, style = MaterialTheme.typography.h4,)
        }
    }
}
