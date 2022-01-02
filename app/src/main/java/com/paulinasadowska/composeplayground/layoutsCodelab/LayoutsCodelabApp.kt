package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabApp() {
    Scaffold(
            topBar = { LayoutsCodelabAppBar() },
            bottomBar = { LayoutsCodelabBottomBar() },
    ) { innerPadding ->
        PhotographerCardList(Modifier.padding(innerPadding))
    }
}

@Composable
fun PhotographerCardList(modifier: Modifier = Modifier){
    val scrollState = rememberScrollState()
    Column(modifier.verticalScroll(scrollState)) {
        repeat(100) {
            PhotographerCard(index = it)
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabAppPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabApp()
    }
}
