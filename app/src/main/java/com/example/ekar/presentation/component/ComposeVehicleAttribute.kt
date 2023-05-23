package com.example.ekar.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.ekar.presentation.theme.GREY
import com.example.ekar.presentation.theme.LIGHT_BLUE
import com.example.ekar.presentation.theme.spacing

@Composable
fun ComposeVehicleAttribute(
    label: String,
    value: String,
) {

    ComposeBox() {
        Column(
            modifier = Modifier
                .background(color = LIGHT_BLUE)
                .padding(MaterialTheme.spacing.view_4x),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.h4,
                color = GREY,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = value,
                style = MaterialTheme.typography.caption,
                color = GREY,
                fontWeight = FontWeight.Medium,
            )
        }
    }

}