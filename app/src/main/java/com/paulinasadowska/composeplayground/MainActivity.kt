package com.paulinasadowska.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.paulinasadowska.composeplayground.basicsCodelab.Greetings
import com.paulinasadowska.composeplayground.basicsCodelab.OnboardingScreen
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var showOnboarding by remember { mutableStateOf(true) }
    if (showOnboarding) {
        OnboardingScreen(
                onContinueClicked = { showOnboarding = false }
        )
    } else {
        Greetings()
    }
}