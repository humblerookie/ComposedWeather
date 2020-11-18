package dev.anvith.weather.providers

import dev.anvith.weather.entities.Forecast
import dev.anvith.weather.entities.IntraDayForecast
import dev.anvith.weather.entities.Weather
import dev.anvith.weather.entities.WeatherType.*

/**
 * Created by anvith on 12/11/20.
 */


class WeatherDataProvider {


    fun getWeather(): Weather {

        return Weather(
            "Mumbai",
            "06:00",
            "17:45",
            "14 km",
            "10",
            "23° C",
            "10 km/hr",
            getFiveDayForecast(),
            "20:30"
        )
    }

    private fun getFiveDayForecast(): List<Forecast> {
        val day =
            listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        var currentIndex = 2
        return listOf(
            Forecast(
                "Today",
                CLEAR,
                "22° C",
                listOf(
                    IntraDayForecast(
                        40,
                        "06:00",
                        "18° C",
                        18
                    ),
                    IntraDayForecast(
                        30,
                        "09:00",
                        "20° C",
                        20
                    ),
                    IntraDayForecast(
                        60,
                        "12:00",
                        "24° C",
                        24
                    ),
                    IntraDayForecast(
                        20,
                        "15:00",
                        "23° C",
                        23
                    ),
                    IntraDayForecast(
                        32,
                        "18:00",
                        "19° C",
                        19
                    ),
                    IntraDayForecast(
                        20,
                        "21:00",
                        "17° C",
                        17
                    )
                )
            ),
            Forecast(
                day[++currentIndex % day.size],
                CLOUD,
                "20° C",
                listOf(

                    IntraDayForecast(
                        40,
                        "06:00",
                        "18° C",
                        18
                    ),
                    IntraDayForecast(
                        30,
                        "09:00",
                        "20° C",
                        20
                    ),
                    IntraDayForecast(
                        60,
                        "12:00",
                        "24° C",
                        24
                    ),
                    IntraDayForecast(
                        20,
                        "15:00",
                        "23° C",
                        23
                    ),
                    IntraDayForecast(
                        32,
                        "18:00",
                        "19° C",
                        19
                    ),
                    IntraDayForecast(
                        20,
                        "21:00",
                        "17° C",
                        17
                    )
                )
            ),
            Forecast(
                day[++currentIndex % day.size],
                RAINY,
                "18° C",
                listOf(

                    IntraDayForecast(
                        40,
                        "06:00",
                        "18° C",
                        18
                    ),
                    IntraDayForecast(
                        30,
                        "09:00",
                        "20° C",
                        20
                    ),
                    IntraDayForecast(
                        60,
                        "12:00",
                        "24° C",
                        24
                    ),
                    IntraDayForecast(
                        20,
                        "15:00",
                        "23° C",
                        23
                    ),
                    IntraDayForecast(
                        32,
                        "18:00",
                        "19° C",
                        19
                    ),
                    IntraDayForecast(
                        20,
                        "21:00",
                        "17° C",
                        17
                    )
                )
            ),
            Forecast(
                day[++currentIndex % day.size],
                THUNDER,
                "17° C",
                listOf(

                    IntraDayForecast(
                        40,
                        "06:00",
                        "18° C",
                        18
                    ),
                    IntraDayForecast(
                        30,
                        "09:00",
                        "20° C",
                        20
                    ),
                    IntraDayForecast(
                        60,
                        "12:00",
                        "24° C",
                        24
                    ),
                    IntraDayForecast(
                        20,
                        "15:00",
                        "23° C",
                        23
                    ),
                    IntraDayForecast(
                        32,
                        "18:00",
                        "19° C",
                        19
                    ),
                    IntraDayForecast(
                        20,
                        "21:00",
                        "17° C",
                        17
                    )
                )
            ), Forecast(
                day[++currentIndex % day.size],
                CLEAR,
                "25° C",
                listOf(

                    IntraDayForecast(
                        40,
                        "06:00",
                        "18° C",
                        18
                    ),
                    IntraDayForecast(
                        30,
                        "09:00",
                        "20° C",
                        20
                    ),
                    IntraDayForecast(
                        60,
                        "12:00",
                        "24° C",
                        24
                    ),
                    IntraDayForecast(
                        20,
                        "15:00",
                        "23° C",
                        23
                    ),
                    IntraDayForecast(
                        32,
                        "18:00",
                        "19° C",
                        19
                    ),
                    IntraDayForecast(
                        20,
                        "21:00",
                        "17° C",
                        17
                    )
                )
            )
        )
    }
}