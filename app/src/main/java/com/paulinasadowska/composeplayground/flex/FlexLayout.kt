package com.paulinasadowska.composeplayground.flex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun FlexLayout(
        modifier: Modifier = Modifier,
        flexDirection: FlexDirection = FlexDirection.Row,
        flexWrap: FlexWrap = FlexWrap.NoWrap,
        content: @Composable FlexLayoutScope.() -> Unit
) {
    if (flexDirection == FlexDirection.Row) {
        if (flexWrap == FlexWrap.Wrap) {
            FlowRow(modifier) {
                FlexLayoutScopeInstance.content()
            }
        } else {
            Row(modifier) {
                FlexLayoutScopeInstance.content()
            }
        }
    } else {
        if (flexWrap == FlexWrap.Wrap) {
            FlowColumn(modifier) {
                FlexLayoutScopeInstance.content()
            }
        } else {
            Column(modifier) {
                FlexLayoutScopeInstance.content()
            }
        }
    }
}

enum class FlexDirection {
    Row, Column, RowReverse, ColumnReverse
}

enum class FlexWrap {
    Wrap, NoWrap, WrapReverse
}

@Preview(showBackground = true, widthDp = 50)
@Composable
fun FlexLayoutPreviewRow() {
    Column {
        Text("wrap: ")
        FlexLayout(
                flexDirection = FlexDirection.Row,
                flexWrap = FlexWrap.Wrap
        ) {
            Numbers()
        }
        Text("no wrap: ")
        FlexLayout(flexDirection = FlexDirection.Row, flexWrap = FlexWrap.NoWrap) {
            List(10) { it }.forEach {
                Text("$it", modifier = Modifier.flexGrow(2f))
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 100)
@Composable
fun FlexLayoutPreviewColumn() {
    Row {
        Text("wrap: ")
        FlexLayout(flexDirection = FlexDirection.Column, flexWrap = FlexWrap.Wrap) {
            Numbers()
        }
        Text("no wrap: ")
        FlexLayout(flexDirection = FlexDirection.Column, flexWrap = FlexWrap.NoWrap) {
            Numbers()
        }
    }
}

@Composable
fun Numbers() {
    List(10) { it }.forEach {
        Text("$it")
    }
}

@LayoutScopeMarker
@Immutable
interface FlexLayoutScope {
    @Stable
    fun Modifier.flexGrow(
            /*@FloatRange(from = 0.0, fromInclusive = false)*/
            weight: Float
    ): Modifier
}

object FlexLayoutScopeInstance : FlexLayoutScope {
    @Stable
    override fun Modifier.flexGrow(weight: Float): Modifier {
        require(weight > 0.0) { "invalid weight $weight; must be greater than zero" }
        return this.then(FlexLayoutGrowImpl(weight = weight))
    }
}

internal data class FlexLayoutParentData(var weight: Float = 0f)

internal class FlexLayoutGrowImpl(val weight: Float) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) =
            ((parentData as? FlexLayoutParentData) ?: FlexLayoutParentData()).also {
                it.weight = weight
            }
}