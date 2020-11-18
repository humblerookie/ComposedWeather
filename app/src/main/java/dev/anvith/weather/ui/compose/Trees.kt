package dev.anvith.weather.ui.compose

import androidx.compose.foundation.layout.ConstraintLayoutBaseScope.HorizontalAnchor
import androidx.compose.foundation.layout.ConstraintLayoutScope
import androidx.compose.foundation.layout.Dimension
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import dev.anvith.weather.R
import dev.anvith.weather.extensions.transitionColor
import dev.anvith.weather.ui.treeColors

/**
 * Created by anvith on 16/11/20.
 */

@Composable
fun ConstraintLayoutScope.Trees(modifier: Modifier = Modifier, mainGuide: HorizontalAnchor, animPercentage: Float) {
    val (treeTops, treeBottoms) = createRefs()
    VectorImage(
        resId = R.drawable.ic_tree_bottoms,
        modifier = modifier.fillMaxWidth().constrainAs(treeBottoms) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(mainGuide)
            height = Dimension.wrapContent
        }
    )
    VectorImage(
        resId = R.drawable.ic_tree_tops,
        modifier = modifier.fillMaxWidth().constrainAs(treeTops) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(mainGuide)
            height = Dimension.wrapContent
        },
        colorFilter = ColorFilter.tint(treeColors.transitionColor(animPercentage))
    )
}