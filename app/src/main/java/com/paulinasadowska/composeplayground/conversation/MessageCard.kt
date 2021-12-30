package com.paulinasadowska.composeplayground.conversation

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.R
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 4.dp)) {
        Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "profile image",
                modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        val (isExpanded, setIsExpanded) = remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )
        Column(modifier = Modifier.clickable { setIsExpanded(!isExpanded) }) {
            Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                    color = surfaceColor,
                    modifier = Modifier
                            .animateContentSize()
                            .padding(1.dp),
                    shape = MaterialTheme.shapes.medium, elevation = 1.dp
            ) {
                Text(
                        text = message.body,
                        modifier = Modifier.padding(4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2
                )
            }

        }
    }

}

@Preview(
        showBackground = true,
        name = "Light mode"
)
@Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark mode"
)
@Composable
fun MessagePreview() {
    ComposePlaygroundTheme {
        MessageCard(Message(author = "Test name", body = "Lorem ipsum..."))
    }
}

data class Message(val author: String, val body: String)