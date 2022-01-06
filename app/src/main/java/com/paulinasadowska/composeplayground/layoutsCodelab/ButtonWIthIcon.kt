package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favourite"
        )
        Spacer(Modifier.width(8.dp))
        Text("Button")
    }
}


@Composable
@Preview
fun ButtonWIthIconPreview() {
    ComposePlaygroundTheme {
        ButtonWithIcon()
    }
}