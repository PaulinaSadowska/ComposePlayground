package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(text1,
                modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Divider(color = Color.White,
                modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp))
        Text(text2,
                modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TwoTextsPreview() {
    ComposePlaygroundTheme {
        Surface {
            TwoTexts(text1 = "Hi", text2 = "there is a lot more text in this line to see how it works")
        }
    }
}