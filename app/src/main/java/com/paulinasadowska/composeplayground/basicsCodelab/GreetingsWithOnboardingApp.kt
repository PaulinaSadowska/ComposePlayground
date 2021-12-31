package com.paulinasadowska.composeplayground.basicsCodelab

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun GreetingsWithOnboardingApp() {
    var showOnboarding by rememberSaveable { mutableStateOf(true) }

    Crossfade(targetState = showOnboarding) { onboardingVisible ->
        if (onboardingVisible) {
            OnboardingScreen(onContinueClicked = { showOnboarding = false })
        } else {
            Greetings()
        }
    }
}