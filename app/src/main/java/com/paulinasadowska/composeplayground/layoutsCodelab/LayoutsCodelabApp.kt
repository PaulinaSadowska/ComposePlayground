package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Layers
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabApp() {
    Column {
        TopAppBar(
                title = { Text(text = "Layouts in Jetpack Compose") },
                navigationIcon = {
                    Icon(
                            imageVector = Icons.Default.Layers,
                            contentDescription = "Button with a heart"
                    )
                }
        )
        PhotographerCard()
    }
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabAppPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabApp()
    }
}
