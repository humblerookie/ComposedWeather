package dev.anvith.weather.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadVectorResource
import androidx.compose.ui.unit.dp
import dev.anvith.weather.ui.humidityTeal
import dev.anvith.weather.ui.humidityTeal50

/**
 * Created by anvith on 12/11/20.
 */

@Composable
fun VectorImage(
    resId: Int,
    modifier: Modifier=Modifier,
    colorFilter: ColorFilter? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha
) {
    val imageVector = loadVectorResource(resId)
    imageVector.resource.resource?.let {
        Image(
            asset = it,
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            colorFilter = colorFilter,
            alpha = alpha
        )
    }

}

@Composable
fun DropletImage(modifier: Modifier=Modifier,fillPercent:Int){
    val stop = 1-fillPercent/100f
    Image(
        modifier =modifier,
        painter = rememberVectorPainter(
            defaultWidth = 18.dp,
            defaultHeight = 28.dp,
            viewportWidth = 18f,
            viewportHeight = 28f
        ) { _, _ ->
            Path(
                pathData = addPathNodes("M8.6412,27.8343C12.4817,27.8343 17.0423,25.0746 17.0423,17.9033C17.0423,10.732 8.6412,0 8.6412,0C8.6412,0 -0,10.732 -0,17.9033C-0,25.0746 4.8006,27.8343 8.6412,27.8343Z"),
                pathFillType = PathFillType.EvenOdd,
                fill = VerticalGradient(
                    *listOf(
                        0f to Color.White,
                        stop to Color(0x7FFDFDFD),
                        stop + 0.01f to humidityTeal50,
                        1f to humidityTeal
                    ).toTypedArray(),
                    startY = 0f,
                    endY = 28f
                ),
                strokeLineWidth = 1f,
            )

        })
}