package com.paulinasadowska.composeplayground.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun MainMenuItem(index: Int, title: String, subtitle: String, onMenuOptionClicked: () -> Unit) {
    Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier.clickable { onMenuOptionClicked() }
    ) {
        Row(Modifier.padding(all = 16.dp)) {
            Text(
                    text = "$index",
                    style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.ExtraBold)
            )
            Column(Modifier
                    .padding(start = 16.dp, top = 8.dp)
                    .weight(1f)
            ) {
                Text(title, style = MaterialTheme.typography.h6)
                Text(subtitle, style = MaterialTheme.typography.subtitle1)
            }
        }

    }
}

@Composable
@Preview(
        showBackground = true,
        widthDp = 320,
)
fun MenuItemPreview() {
    ComposePlaygroundTheme {
        MainMenuItem(
                index = 1,
                title = "Test title",
                subtitle = "Some subtitle",
                onMenuOptionClicked = {})
    }
}