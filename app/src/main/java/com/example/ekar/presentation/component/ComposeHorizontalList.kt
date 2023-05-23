package com.example.ekar.presentation.component

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> ComposeHorizontalList(
    modifier: Modifier = Modifier,
    list: List<T>,
    item: @Composable (T, Int) -> Unit,
) {
    LazyRow(modifier = modifier) {
        itemsIndexed(list) { index, item ->
            item(item, index)
        }
    }
}