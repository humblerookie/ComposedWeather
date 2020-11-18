package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.ConstraintLayoutScope
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import dev.anvith.weather.R
import dev.anvith.weather.extensions.degrade
import kotlin.math.sqrt

/**
 * Created by anvith on 15/11/20.
 */

@Composable()
fun ConstraintLayoutScope.Sun(modifier: Modifier = Modifier, animPercentage: Float) {
    val horizontalStart = createGuidelineFromStart(0.1f)
    val horizontalEnd = createGuidelineFromStart(0.9f)
    val yStart = getVerticalCoordinate(animPercentage)
    val verticalStart = createGuidelineFromTop(yStart)
    val sunRef = createRef()
    val size = dimensionResource(id = R.dimen.sun_size)
    VectorImage(
        resId = R.drawable.ic_sun,
        modifier = modifier.width(size).constrainAs(sunRef) {
            linkTo(start = horizontalStart, end = horizontalEnd, bias = animPercentage)
            top.linkTo(verticalStart)
        },
        alpha = (1 - animPercentage).degrade(0.3f)
    )
}


private fun getVerticalCoordinate(percentage: Float): Float {
    val x = percentage * 0.8f + 0.1f
    val y = 0.7 - sqrt(x - x * x)
    return y.toFloat()
}