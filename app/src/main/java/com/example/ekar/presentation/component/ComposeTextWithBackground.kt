package com.example.ekar.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.ekar.data.remote.dto.VehicleDetail
import com.example.ekar.presentation.theme.LIGHT_BLUE
import com.example.ekar.presentation.theme.fontSize
import com.example.ekar.presentation.theme.spacing

@Composable
fun ComposeTextWithBackground(
    modifier: Modifier = Modifier,
    warranty: VehicleDetail.Warranty,
    radius: Dp = MaterialTheme.spacing.view_4x,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    backgroundColor: Color = LIGHT_BLUE,
) {
    Box(
        modifier = modifier
            .padding(end = MaterialTheme.spacing.view_1x)
            .clip(RoundedCornerShape(radius))
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(MaterialTheme.spacing.view_2x),
            verticalArrangement = Arrangement.Center
        ) {
            RichText(
                text1 = "Type ", text2 = warranty.type, text2Style = SpanStyle(
                    fontSize = MaterialTheme.fontSize.view_18x
                )
            )
            RichText(
                text1 = "Miles ", text2 = warranty.miles, text2Style = SpanStyle(
                    fontSize = MaterialTheme.fontSize.view_18x
                )
            )
            RichText(
                text1 = "Months ", text2 = warranty.months, text2Style = SpanStyle(
                    fontSize = MaterialTheme.fontSize.view_18x
                )
            )
        }
    }
}