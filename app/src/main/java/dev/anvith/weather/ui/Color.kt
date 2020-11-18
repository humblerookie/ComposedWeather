package dev.anvith.weather.ui

import androidx.compose.ui.graphics.Color

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)
val colorOnPrimary = Color(0xDEFFFFFF)


val morningGradient = listOf(
    0f to Color(0xFF1871DA),
    0.38f to Color(0xE697CBFA),
    0.46f to Color(0xBAE7EDED),
    0.6f to Color(0xBA75A2CC),
    0.85f to Color(0xFF79A4CC),
    1f to Color(0xFF79A4CC)
)
val afternoonGradient = listOf(
    0f to Color(0xFFFFBBAA),
    0.08f to Color(0xFFFFC5B7),
    0.18f to Color(0xFFFFCCC0),
    0.44f to Color(0xFFFAE9DA),
    0.62f to Color(0xE6E2B3A8),
    0.9f to Color(0xFFBB958C)
)
val nightGradient = listOf(
    0f to Color(0xFF182449),
    0.3f to Color(0xFF3F568B),
    0.4f to Color(0xFF8088B2),
    1f to Color(0xFF3F568B)
)

val mountainColors = listOf(
    Color(0xFFC1D8F0),
    Color(0xFF8BA7C4),
    Color(0xFF3F568B),
)

val treeColors = listOf(
    Color(0xFFD68811),
    Color(0xFFA96702),
    Color(0xFFC6A1B9),
)

val weatherTextColor = listOf(
    colorOnPrimary,
    colorOnPrimary,
    Color(0xFFF7F2D2),
)

val starsColor = listOf(
    Color.Transparent,
    Color.Transparent,
    Color.White,
)

val humidityTeal50 =Color(0x7F06567D)
val humidityTeal =Color(0xFF06567D)
