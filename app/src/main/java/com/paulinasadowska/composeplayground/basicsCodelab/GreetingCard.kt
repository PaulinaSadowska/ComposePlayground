package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun GreetingCard(name: String) {

    val (isExpanded, setIsExpanded) = remember { mutableStateOf(false) }
    val animatedBackground by animateColorAsState(if (isExpanded) MaterialTheme.colors.secondary else MaterialTheme.colors.primary)

    Surface(
            color = animatedBackground,
            modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .animateContentSize(animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                    ))
    ) {

        Row(
                modifier = Modifier.padding(24.dp)
        ) {
            val extraPadding = animateDpAsState(if (isExpanded) 48.dp else 0.dp,
                    animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                    ))
            Column(
                    modifier = Modifier
                            .padding(end = 16.dp)
                            .weight(1f)
                            .padding(bottom = extraPadding.value.coerceAtLeast(0.dp))
            ) {
                Text("Hello,")
                Text(name)
            }
            OutlinedButton(
                    onClick = { setIsExpanded(!isExpanded) }
            ) {
                Text(text = if (isExpanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingCardPreview() {
    ComposePlaygroundTheme {
        GreetingCard(name = "Compose")
    }
}
