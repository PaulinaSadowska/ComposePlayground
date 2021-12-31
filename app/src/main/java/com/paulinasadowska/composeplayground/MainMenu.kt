package com.paulinasadowska.composeplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun MainMenu(onMenuOptionClicked: (AppScreens) -> Unit) {

    Column(modifier = Modifier.padding(all = 16.dp)) {
        MainMenuItem(
                index = 0,
                title = "Jetpack Compose basics (article)",
                subtitle = "Simple chat screen",
                onMenuOptionClicked = {
                    onMenuOptionClicked(AppScreens.CHAT)
                },
        )
        Spacer(modifier = Modifier.height(16.dp))
        MainMenuItem(
                index = 1,
                title = "Jetpack Compose basics (codelab)",
                subtitle = "Greetings with onboarding"
        ) {
            onMenuOptionClicked(AppScreens.BASICS_CODELAB)
        }
    }
}

@Composable
fun MainMenuItem(index: Int, title: String, subtitle: String, onMenuOptionClicked: () -> Unit) {
    Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                    .clickable { onMenuOptionClicked() }

    ) {
        Row(
                modifier = Modifier.padding(all = 16.dp)
        ) {
            Text(
                    text = "$index",
                    style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.ExtraBold)
            )
            Column(
                    modifier = Modifier
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
fun MainMenuPreview() {
    ComposePlaygroundTheme {
        MainMenu(onMenuOptionClicked = {})
    }
}