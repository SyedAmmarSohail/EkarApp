package com.example.ekar.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.ekar.presentation.theme.spacing

@Composable
fun ComposeBox(
    modifier: Modifier = Modifier,
    radius: Dp = MaterialTheme.spacing.view_4x,
    padding: Dp = MaterialTheme.spacing.view_2x,
    backgroundColor: Color = Color.Transparent,
    shadowElevation: Dp = MaterialTheme.spacing.view_1x,
    child: @Composable() (() -> Unit)? = null
) {

    Card(
        shape = RoundedCornerShape(radius),
        elevation = shadowElevation,
        modifier = modifier
            .background(backgroundColor)
            .padding(padding)
    ) {
        child?.let { it() }
    }
}