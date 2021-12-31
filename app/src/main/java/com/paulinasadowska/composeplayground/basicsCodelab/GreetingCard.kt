package com.paulinasadowska.composeplayground.basicsCodelab

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composeplayground.R
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun GreetingCard(name: String) {

    val (expanded, setIsExpanded) = remember { mutableStateOf(false) }
    Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .clickable { setIsExpanded(!expanded) }
    ) {
        Row(
                modifier = Modifier.animateContentSize(animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                ))
        ) {
            Column(
                    modifier = Modifier
                            .padding(all = 16.dp)
                            .weight(1f)
            ) {
                Text("Hello,")
                Text(name, style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                ))
                if (expanded) {
                    Text(LOREM_IPSUM)
                }
            }
            IconButton(onClick = { setIsExpanded(!expanded) }) {
                Icon(
                        imageVector = expandIconVector(expanded),
                        contentDescription = stringResource(expandIconDescription(expanded)))
            }
        }
    }
}

fun expandIconVector(expanded: Boolean) = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore
fun expandIconDescription(expanded: Boolean) = if (expanded) R.string.show_less else R.string.show_more

@Composable
@Preview(showBackground = true)
@Preview(
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        name = "GreetingCardPreviewDark"
)
fun GreetingCardPreview() {
    ComposePlaygroundTheme {
        GreetingCard(name = "Compose")
    }
}

private const val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
        "eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
        "laboris nisi ut aliquip ex ea commodo consequat."
