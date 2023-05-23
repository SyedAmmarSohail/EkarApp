package com.example.ekar.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.example.ekar.presentation.theme.BLUE
import com.example.ekar.presentation.theme.spacing

@Composable
fun ActionAppBar(
    title: String,
    backEnabled: Boolean = false,
    leadingIcon: ImageVector = Icons.Filled.ArrowBack,
    onBack: () -> Unit,
) {
    TopAppBar(
        elevation = MaterialTheme.spacing.view_1x,
        backgroundColor = MaterialTheme.colors.primarySurface,
    ) {
        Box {
            if (backEnabled)
                IconButton(
                    onClick = onBack,
                ) {
                    Icon(leadingIcon, null)
                }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.h2.copy(color = BLUE),
                textAlign = TextAlign.Center
            )
        }
        Row {
        }
    }

}