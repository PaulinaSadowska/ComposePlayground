package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.padding
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
        PhotographerCard(Modifier.padding(innerPadding))
    }

}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabAppPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabApp()
    }
}
