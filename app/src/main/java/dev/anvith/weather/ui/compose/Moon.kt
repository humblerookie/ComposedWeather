package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.ConstraintLayoutScope
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import dev.anvith.weather.R
import dev.anvith.weather.extensions.PERIOD
import dev.anvith.weather.extensions.degrade
import dev.anvith.weather.extensions.period

/**
 * Created by anvith on 15/11/20.
 */

@Composable()
fun ConstraintLayoutScope.Moon(modifier: Modifier = Modifier, animPercentage: Float) {
    val horizontalStart = createGuidelineFromStart(0.55f)
    val horizontalEnd = createGuidelineFromStart(0.9f)
    val verticalStart = createGuidelineFromTop(0.05f)
    val verticalEnd = createGuidelineFromTop(0.3f)
    val moonRef = createRef()
    val size = dimensionResource(id = R.dimen.sun_size)
    val alpha = if(animPercentage.period() ==PERIOD.AFTERNOON)0f else animPercentage
    VectorImage(
        resId = R.drawable.ic_moon,
        modifier = modifier.width(size).constrainAs(moonRef) {
            linkTo(start = horizontalStart, end = horizontalEnd, bias = 1 - animPercentage * animPercentage)
            linkTo(top = verticalStart, bottom = verticalEnd, bias = 1 - animPercentage * animPercentage)
        },
        alpha =  alpha.degrade(0.4f)
    )
}
