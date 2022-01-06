package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun MyOwnColumn(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
) {
    Layout(
            modifier = modifier,
            content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        var yPosition = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach { placeable ->
                placeable.placeRelative(0, yPosition)
                yPosition += placeable.height
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyOwnColumnPreview() {
    ComposePlaygroundTheme {
        MyOwnColumn(Modifier.padding(8.dp)) {
            Text("1")
            Text("2")
            Text("3")
        }
    }
}