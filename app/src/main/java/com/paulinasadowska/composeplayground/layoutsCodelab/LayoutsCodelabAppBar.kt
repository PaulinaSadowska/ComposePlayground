package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabAppBar() {
    TopAppBar(
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