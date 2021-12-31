package com.paulinasadowska.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.paulinasadowska.composeplayground.basicsCodelab.GreetingsWithOnboardingApp
import com.paulinasadowska.composeplayground.conversation.Conversation
import com.paulinasadowska.composeplayground.conversation.SampleData
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                var screenToShow by remember { mutableStateOf(AppScreens.MENU) }
                when (screenToShow) {
                    AppScreens.MENU -> MainMenu(onMenuOptionClicked = { screenToShow = it })
                    AppScreens.CHAT -> Conversation(messages = SampleData.conversationSample)
                    AppScreens.BASICS_CODELAB -> GreetingsWithOnboardingApp()
                }
            }
        }
    }
}

enum class AppScreens {
    MENU, CHAT, BASICS_CODELAB
}