package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun GreetingCard(name: String) {
    Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
                modifier = Modifier.padding(24.dp)
        ) {
            val (isExpanded, setIsExpanded) = remember { mutableStateOf(false) }
            Column(
                    modifier = Modifier
                            .padding(end = 16.dp)
                            .weight(1f)
            ) {
                Text("Hello,")
                Text(name)
                if (isExpanded) {
                    Text(text = LOREM_IPSUM)
                }
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

const val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."