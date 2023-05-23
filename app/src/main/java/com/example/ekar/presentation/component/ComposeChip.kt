package com.example.ekar.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ekar.presentation.theme.BLUE
import com.example.ekar.presentation.theme.spacing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ComposeChip(
    value: String,
    background: Color = Color.White,
    contentColor: Color = BLUE,
    borderColor: Color = BLUE
) {
    Chip(
        modifier = Modifier.padding(MaterialTheme.spacing.view_1x),
        onClick = { },
        border = BorderStroke(
            ChipDefaults.OutlinedBorderSize,
            borderColor
        ),
        colors = ChipDefaults.chipColors(
            backgroundColor = background,
            contentColor = contentColor
        )
    ) {
        Text(value)
    }
}