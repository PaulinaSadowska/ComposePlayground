package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabAppBar() {
    TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            title = { Text(text = "Layouts in Jetpack Compose") },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null
                    )
                }
            }
    )
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabAppBarPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabAppBar()
    }
}