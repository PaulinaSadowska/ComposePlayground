package com.paulinasadowska.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.paulinasadowska.composeplayground.basicsCodelab.GreetingsWithOnboardingApp
import com.paulinasadowska.composeplayground.conversation.Conversation
import com.paulinasadowska.composeplayground.conversation.SampleData
import com.paulinasadowska.composeplayground.layoutsCodelab.LayoutsCodelabApp
import com.paulinasadowska.composeplayground.menu.MainMenu
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                var screenToShow by remember { mutableStateOf(AppScreens.LayoutsCodelab) }
                when (screenToShow) {
                    AppScreens.Menu -> MainMenu(onMenuOptionClicked = { screenToShow = it })
                    AppScreens.Chat -> Conversation(messages = SampleData.conversationSample)
                    AppScreens.BasicsCodelab -> GreetingsWithOnboardingApp()
                    AppScreens.LayoutsCodelab -> LayoutsCodelabApp()
                }
            }
        }
    }
}

enum class AppScreens {
    Menu, Chat, BasicsCodelab, LayoutsCodelab
}