package com.paulinasadowska.composeplayground.basicsCodelab

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface(
            color = MaterialTheme.colors.surface
    ) {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = "Welcome to the Basics Codelab!",
                    color = MaterialTheme.colors.onSurface
            )
            Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
@Preview(
        showBackground = true,
        widthDp = 320,
        heightDp = 320,
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        name = "GreetingsPreviewDark")
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
fun OnboardingScreenPreview() {
    ComposePlaygroundTheme {
        OnboardingScreen { }
    }
}