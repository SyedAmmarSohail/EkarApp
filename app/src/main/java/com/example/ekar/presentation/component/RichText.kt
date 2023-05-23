package com.example.ekar.presentation.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.ekar.presentation.theme.DARK_GREY
import com.example.ekar.presentation.theme.fontSize

@Composable
fun RichText(
    text1: String,
    text2: String,
    text1Style: SpanStyle = SpanStyle(
        fontSize = MaterialTheme.fontSize.view_12x
    ),
    text2Style: SpanStyle = SpanStyle(
        fontSize = MaterialTheme.fontSize.view_12x
    ),
    textColor: Color = DARK_GREY
) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = text1Style
            ) {
                append(text1)
            }
            append(" ")
            withStyle(
                style = text2Style
            ) {
                append(text2)
            }
        },
        color = textColor,
        fontWeight = FontWeight.SemiBold,
    )
}