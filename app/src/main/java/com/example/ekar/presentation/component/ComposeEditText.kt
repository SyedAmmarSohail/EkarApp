package com.example.ekar.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.ekar.presentation.theme.BLUE
import com.example.ekar.presentation.theme.DARK_GREY

@Composable
fun ComposeEditText(
    text: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    textColor: Color = DARK_GREY,
    hintText: String = "",
    isError: Boolean = false,
    errorMessage: String = "",
    valueChangeCallback: (String) -> Unit,
) {
    Column {
        Text(
            text = "Leave a comment:",
            style = MaterialTheme.typography.caption,
            color = DARK_GREY,
            fontWeight = FontWeight.Medium,
        )
        TextField(
            value = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            onValueChange = valueChangeCallback,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = BLUE,
                unfocusedIndicatorColor = DARK_GREY,
                backgroundColor = Color.White,
                textColor = textColor
            ),
            isError = isError,
            modifier = modifier
                .fillMaxWidth(),
            placeholder = {
                Text(text = hintText, color = DARK_GREY)
            }
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}