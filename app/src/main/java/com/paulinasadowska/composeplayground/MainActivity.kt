package com.paulinasadowska.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.paulinasadowska.composeplayground.basicsCodelab.GreetingsWithOnboardingApp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                GreetingsWithOnboardingApp()
            }
        }
    }
}