package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlin.math.max


@Composable
fun StaggeredGrid(
        modifier: Modifier = Modifier,
        rows: Int = 3,
        content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val rowWidths = IntArray(rows) { 0 }
        val rowHeights = IntArray(rows) { 0 }
        val placeables = measurables.mapIndexed { index, measurable ->
            val placeable = measurable.measure(constraints)
            val row = index % rows
            rowWidths[row] += placeable.width
            rowHeights[row] = max(placeable.height, rowHeights[row])
            placeable
        }

        val width = rowWidths.maxOrNull()
                ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth))
                ?: constraints.minWidth
        val height = rowHeights.sumOf { it }
                .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }

        layout(width, height) {
            val rowX = IntArray(rows) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(
                        x = rowX[row],
                        y = rowY[row],
                )
                rowX[row] += placeable.width
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StaggeredGridPreview() {
    ComposePlaygroundTheme {
        StaggeredGrid(Modifier.background(MaterialTheme.colors.surface)) {
            List(100) { it }.forEach {
                Text(
                        text = "$it",
                        modifier = Modifier
                                .padding(4.dp)
                                .background(MaterialTheme.colors.onSurface)
                                .padding(4.dp)
                )
            }
        }
    }
}