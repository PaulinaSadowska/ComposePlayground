package com.paulinasadowska.composeplayground.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.AppScreens
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun MainMenu(onMenuOptionClicked: (AppScreens) -> Unit) {

    Column(modifier = Modifier.padding(all = 16.dp)) {
        MainMenuItem(
                index = 0,
                title = "Jetpack Compose basics (article)",
                subtitle = "Simple chat screen",
                onMenuOptionClicked = {
                    onMenuOptionClicked(AppScreens.Chat)
                },
        )
        Spacer(modifier = Modifier.height(16.dp))
        MainMenuItem(
                index = 1,
                title = "Jetpack Compose basics (codelab)",
                subtitle = "Greetings with onboarding"
        ) {
            onMenuOptionClicked(AppScreens.BasicsCodelab)
        }
        Spacer(modifier = Modifier.height(16.dp))
        MainMenuItem(
                index = 2,
                title = "Layouts in Jetpack Compose",
                subtitle = "..."
        ) {
            onMenuOptionClicked(AppScreens.LayoutsCodelab)
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