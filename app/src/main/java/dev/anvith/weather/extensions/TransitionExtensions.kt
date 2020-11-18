package dev.anvith.weather.extensions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import dev.anvith.weather.extensions.PERIOD.*

/**
 * Created by anvith on 17/11/20.
 */


fun Float.period(): PERIOD {
    return when (this) {
        in 0f..MORNING_LIMIT -> MORNING
        in MORNING_LIMIT..AFTERNOON_LIMIT -> AFTERNOON
        else -> NIGHT
    }
}

fun Float.transitionPercentage(): Float {
    return when (this) {
        in MORNING_LIMIT_HALF..AFTERNOON_LIMIT_HALF -> (this - MORNING_LIMIT_HALF) / (AFTERNOON_LIMIT_HALF - MORNING_LIMIT_HALF)
        in AFTERNOON_LIMIT_HALF..NIGHT_LIMIT_HALF -> (this - AFTERNOON_LIMIT_HALF) / (NIGHT_LIMIT_HALF - AFTERNOON_LIMIT_HALF)
        in NIGHT_LIMIT_HALF..1f -> (this - NIGHT_LIMIT_HALF) / (1f + MORNING_LIMIT_HALF - NIGHT_LIMIT_HALF)
        else -> (this + 1f - NIGHT_LIMIT_HALF) / (1f + MORNING_LIMIT_HALF - NIGHT_LIMIT_HALF)
    }
}

fun List<Color>.transitionColor(percentage: Float): Color {
    val (startColor, endColor) = when (percentage) {
        in MORNING_LIMIT_HALF..AFTERNOON_LIMIT_HALF -> this[0] to this[1]
        in AFTERNOON_LIMIT_HALF..NIGHT_LIMIT_HALF -> this[1] to this[2]
        else -> this[2] to this[0]
    }
    val color = ColorUtils.blendARGB(
        startColor.toArgb(),
        endColor.toArgb(),
        percentage.transitionPercentage()
    )
    return Color(color)
}

enum class PERIOD {
    MORNING,
    AFTERNOON,
    NIGHT
}

fun Float.degrade(level: Float): Float {
    return if (this < level) level * level else this
}

const val MORNING_LIMIT_HALF = 0.11f
const val MORNING_LIMIT = 0.22f
const val AFTERNOON_LIMIT_HALF = 0.365f
const val AFTERNOON_LIMIT = 0.51f
const val NIGHT_LIMIT_HALF = 0.75f