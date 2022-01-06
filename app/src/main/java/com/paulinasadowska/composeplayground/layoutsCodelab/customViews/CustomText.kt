package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun CustomText(baseline: Dp = 10.dp, text: String) {
    Text(text, modifier = Modifier.firstBaselineToTop(baseline))
}

fun Modifier.firstBaselineToTop(
        firstBaselineToTop: Dp
) = this.then(
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            // Check the composable has a first baseline
            check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
            val firstBaseline = placeable[FirstBaseline]

            val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
            val height = placeableY + placeable.height

            layout(placeable.width, height) {
                placeable.placeRelative(0, placeableY)
            }
        }
)

@Preview(showBackground = true)
@Composable
fun CustomTextPreview() {
    ComposePlaygroundTheme {
        Column {
            CustomText(0.dp, "0 dp")
            Spacer(Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface))
            CustomText(50.dp, "50 dp")
            Spacer(Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface))
            CustomText(20.dp, "20 dp")
            Spacer(Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface))
            CustomText(0.dp, "0 dp")
        }

    }
}