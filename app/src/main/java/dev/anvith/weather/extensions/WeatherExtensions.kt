package dev.anvith.weather.extensions

import android.content.Context
import dev.anvith.weather.R
import dev.anvith.weather.entities.WeatherType
import dev.anvith.weather.entities.WeatherType.CLEAR
import dev.anvith.weather.entities.WeatherType.CLOUD
import dev.anvith.weather.entities.WeatherType.RAINY
import dev.anvith.weather.entities.WeatherType.THUNDER

/**
 * Created by anvith on 12/11/20.
 */

fun WeatherType.toDrawable(isNight: Boolean = false): Int {
    return when (this) {
        RAINY -> R.drawable.ic_rainy
        CLOUD -> R.drawable.ic_cloud
        CLEAR -> if (isNight) R.drawable.ic_night_clear else R.drawable.ic_day_clear
        THUNDER -> R.drawable.ic_thunder
    }
}