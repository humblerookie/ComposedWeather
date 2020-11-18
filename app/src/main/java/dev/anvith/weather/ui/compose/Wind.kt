package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.anvith.weather.R

/**
 * Created by anvith on 18/11/20.
 */

@Composable
fun WindSpeed(
    modifier: Modifier = Modifier,
    windSpeed: String
) {

    Column(modifier = modifier.padding(start = 16.dp)) {
        VectorImage(
            resId = R.drawable.ic_wind,
            modifier = modifier.align(alignment = Alignment.Start).width(32.dp)
        )
        Text(
            text = windSpeed,
            style = MaterialTheme.typography.body2
        )
    }
}
