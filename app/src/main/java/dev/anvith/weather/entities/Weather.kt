package dev.anvith.weather.entities

/**
 * Created by anvith on 12/11/20.
 */
data class Weather(
    val location: String,
    val sunrise: String,
    val sunset: String,
    val visibility: String,
    val uvIndex: String,
    val temperature: String,
    val windSpeed: String,
    val fiveDayForecast: List<Forecast>,
    val currentTime:String,
)

data class Forecast(
    val day: String,
    val type: WeatherType,
    val temperature: String,
    val intraDayVariance: List<IntraDayForecast>
)

data class IntraDayForecast(
    val humidity: Int,
    val time: String,
    val temperature: String,
    val temperatureValue:Int
)

enum class WeatherType {
    RAINY,
    CLOUD,
    CLEAR,
    THUNDER
}

