package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabBottomBar() {
    BottomAppBar {
        listOf(Icons.Default.Home, Icons.Default.ShoppingCart, Icons.Default.People).forEach { icon ->
            IconButton(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    onClick = {}
            ) {
                Icon(imageVector = icon, contentDescription = null)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabBottomBarPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabBottomBar()
    }
}