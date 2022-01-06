package com.paulinasadowska.composeplayground.layoutsCodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LayoutsCodelabApp() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
            topBar = { LayoutsCodelabAppBar() },
            bottomBar = {
                LayoutsCodelabBottomBar(
                        onScrollUpClicked = {
                            scrollState.asyncScrollTo(coroutineScope, itemIndex = 0)
                        },
                        onScrollDownClicked = {
                            scrollState.asyncScrollTo(coroutineScope, itemIndex = listSize - 1)
                        }
                )
            },
    ) { innerPadding ->
        PhotographerCardList(Modifier.padding(innerPadding), scrollState, listSize)
    }
}

private fun LazyListState.asyncScrollTo(scope: CoroutineScope, itemIndex: Int) {
    scope.launch { animateScrollToItem(itemIndex) }
}

@Composable
fun PhotographerCardList(modifier: Modifier = Modifier, scrollState: LazyListState, listSize: Int) {
    LazyColumn(modifier, state = scrollState) {
        items(listSize) {
            PhotographerCard(index = it)
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun LayoutsCodelabAppPreview() {
    ComposePlaygroundTheme {
        LayoutsCodelabApp()
    }
}
