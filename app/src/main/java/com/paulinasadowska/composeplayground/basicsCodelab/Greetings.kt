package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun Greetings(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 24.dp)) {
        names.forEach {
            GreetingCard(name = it)
        }
    }
}

@Composable
@Preview
fun GreetingsPreview() {
    ComposePlaygroundTheme {
        Greetings()
    }
}