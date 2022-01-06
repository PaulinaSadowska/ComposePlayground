package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(modifier,
            //border = BorderStroke(color = MaterialTheme.colors.onPrimary, width = Dp.Hairline)
    ) {
        Row(
                modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                    .size(16.dp, 16.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipPreview() {
    ComposePlaygroundTheme {
        Chip(text = "Test!", modifier = Modifier.padding(4.dp))
    }
}