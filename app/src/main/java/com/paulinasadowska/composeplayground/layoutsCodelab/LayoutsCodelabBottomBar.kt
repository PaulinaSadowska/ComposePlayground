package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun LayoutsCodelabBottomBar(
        onScrollDownClicked: () -> Unit = {},
        onScrollUpClicked: () -> Unit = {}
) {
    BottomAppBar(backgroundColor = MaterialTheme.colors.surface) {
        listOf(
                Icons.Default.ArrowUpward to onScrollUpClicked,
                Icons.Default.ArrowDownward to onScrollDownClicked
        ).forEach { (icon, action) ->
            IconButton(
                    modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    onClick = action
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