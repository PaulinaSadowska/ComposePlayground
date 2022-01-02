package com.paulinasadowska.composeplayground.layoutsCodelab

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun PhotographerCard(modifier: Modifier = Modifier, index: Int = 0) {
    Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = modifier.padding(8.dp)
    ) {
        Row(Modifier.padding(16.dp)) {
            Surface(
                    modifier = Modifier.size(50.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.onPrimary.copy(alpha = 0.2f)
            ) {

            }
            Column(Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Alfred Sisley $index", fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text("3 minutes ago", style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
@Preview(
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        name = "PhotographerCardPreviewDark"
)
fun PhotographerCardPreview() {
    ComposePlaygroundTheme {
        PhotographerCard()
    }
}