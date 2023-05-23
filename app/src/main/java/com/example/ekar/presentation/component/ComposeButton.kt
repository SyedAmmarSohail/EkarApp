package com.example.ekar.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ekar.presentation.theme.BLUE
import com.example.ekar.presentation.theme.LIGHT_GREY
import com.example.ekar.presentation.theme.spacing

@Composable
fun ComposeButton(
    modifier: Modifier = Modifier,
    buttonText: String = "",
    backgroundColor: Color = BLUE,
    textColor: Color = Color.White,
    innerPadding: Dp = MaterialTheme.spacing.view_0,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(if (enabled) backgroundColor else LIGHT_GREY),
        enabled = enabled,
        border = BorderStroke(2.dp, BLUE),
        shape = MaterialTheme.shapes.medium,
        elevation = ButtonDefaults.elevation(0.dp),
    ) {
        Text(
            modifier = Modifier.padding(innerPadding),
            text = buttonText,
            textAlign = TextAlign.Center,
            color = textColor,
            style = textStyle,
        )
    }
}