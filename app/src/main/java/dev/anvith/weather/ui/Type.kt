package dev.anvith.weather.ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.unit.sp
import dev.anvith.weather.R

private val cabin = fontFamily(
    font(R.font.cabin_regular),
    font(R.font.cabin_medium, FontWeight.W500),
    font(R.font.cabin_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val typography = Typography(
    body1 = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = colorOnPrimary
    ),
    body2 = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = colorOnPrimary
    ),
    //Other default text styles to override
    button = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = colorOnPrimary
    ),
    h1 = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        color = colorOnPrimary
    ),
    h4 = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = colorOnPrimary
    ),
    h6 = TextStyle(
        fontFamily = cabin,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = colorOnPrimary
    ),


)

