package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.ConstraintLayoutBaseScope.HorizontalAnchor
import androidx.compose.foundation.layout.ConstraintLayoutScope
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.SrcAtop
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import dev.anvith.weather.R
import dev.anvith.weather.extensions.transitionColor
import dev.anvith.weather.ui.mountainColors

/**
 * Created by anvith on 16/11/20.
 */

@Composable
fun ConstraintLayoutScope.Mountain(modifier: Modifier=Modifier, mainGuide:HorizontalAnchor, animPercentage:Float){
    val (mountainBack,mountainFront) =createRefs()
    VectorImage(
        resId = R.drawable.ic_mountain_back,
        modifier = modifier.fillMaxWidth().constrainAs(mountainBack) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(mainGuide)
            height = Dimension.wrapContent
        },
        colorFilter = ColorFilter(color = getMountainBackColor(percentage = animPercentage),SrcAtop)

    )
    VectorImage(
        resId = R.drawable.ic_mountain_front,
        modifier = modifier.fillMaxWidth().constrainAs(mountainFront) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(mainGuide)
            height = Dimension.wrapContent
        },
       colorFilter = ColorFilter(color = getMountainFrontColor(percentage = animPercentage),SrcAtop)
    )
}

private  fun getMountainFrontColor(percentage: Float):Color{
   return mountainColors.transitionColor(percentage)
}
private  fun getMountainBackColor(percentage: Float):Color{
    return mountainColors.map { it.copy(alpha = 0.65f) }.transitionColor(percentage)
}


