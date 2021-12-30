package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun GreetingsWithOnboardingApp() {
    var showOnboarding by rememberSaveable { mutableStateOf(true) }
    if (showOnboarding) {
        OnboardingScreen(
                onContinueClicked = { showOnboarding = false }
        )
    } else {
        Greetings()
    }
}