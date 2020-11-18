package dev.anvith.weather.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.anvith.weather.ui.colorOnPrimary

/**
 * Created by anvith on 18/11/20.
 */


@Composable
fun ConstraintLayoutScope.HorizontalDivider(
    modifier: Modifier = Modifier,
    selfRef: ConstrainedLayoutReference,
    topRef: ConstrainedLayoutReference,
    bottomRef: ConstrainedLayoutReference? = null
) {
    Box(modifier = modifier.height(18.dp).padding(vertical = 8.dp).constrainAs(selfRef) {
        linkTo(top = topRef.bottom, bottom = (bottomRef ?: parent).top)
        linkTo(start = parent.start, end = parent.end)
    }.background(color = colorOnPrimary, shape = RoundedCornerShape(1.dp)).fillMaxWidth(0.8f))

}

