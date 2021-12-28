package com.paulinasadowska.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MessageCard(Message(author = "Paulina", body = "Lorem ipsum..."))
                }
            }
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 4.dp)) {
        Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "profile image",
                modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = message.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.body)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        MessageCard(Message(author = "Test name", body = "Lorem ipsum..."))
    }
}

data class Message(val author: String, val body: String)