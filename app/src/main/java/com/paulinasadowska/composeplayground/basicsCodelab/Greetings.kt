package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 24.dp)) {
        items(names) {
            GreetingCard(name = it)
        }
    }
}

@Composable
@Preview
fun GreetingsPreview() {
    ComposePlaygroundTheme {
        Greetings(listOf("Compose", "Test"))
    }
}