package com.paulinasadowska.composeplayground.layoutsCodelab.constraintLayout

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

/*
 * Note: In the View system, ConstraintLayout was the recommended way
 * to create large and complex layouts as the flat view hierarchy
 * was better for performance.
 * However, this is not a concern in Compose, which is able to
 * efficiently handle deep layout hierarchies.
 */
@Composable
fun ConstraintLayoutContent() {

    ConstraintLayout {

        val (button1, button2, text) = createRefs()
        Button(onClick = {}, modifier = Modifier.constrainAs(button1) {
            top.linkTo(parent.top, 16.dp)
        }) {
            Text("Button1")
        }
        val barrier = createEndBarrier(button1, text)
        Text("Test", modifier = Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })

        Button(onClick = {}, modifier = Modifier.constrainAs(button2) {
            top.linkTo(parent.top, 16.dp)
            start.linkTo(barrier, 16.dp)
        }) {
            Text("Button2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
    ComposePlaygroundTheme {
        ConstraintLayoutContent()
    }
}

@Composable
fun LargeConstraintLayout() {
    ConstraintLayout {
        val text = createRef()

        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
                text = "This is a very very very very very very very long text",
                Modifier.constrainAs(text) {
                    linkTo(start = guideline, end = parent.end)
                    width = Dimension.preferredWrapContent
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LargeConstraintLayoutPreview() {
    ComposePlaygroundTheme {
        LargeConstraintLayout()
    }
}


@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                    onClick = { /* Do something */ },
                    modifier = Modifier.layoutId("button", tag = "")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text", tag = ""))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DecoupledConstraintLayoutPreview() {
    ComposePlaygroundTheme {
        DecoupledConstraintLayout()
    }
}