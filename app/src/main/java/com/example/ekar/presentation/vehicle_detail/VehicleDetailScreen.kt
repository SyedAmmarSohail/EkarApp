package com.example.ekar.presentation.vehicle_detail

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import coil.annotation.ExperimentalCoilApi
import com.example.ekar.R
import com.example.ekar.data.remote.dto.VehicleDetail
import com.example.ekar.presentation.EkarEvent
import com.example.ekar.presentation.EkarViewModel
import com.example.ekar.presentation.component.ActionAppBar
import com.example.ekar.presentation.component.ComposeButton
import com.example.ekar.presentation.component.ComposeChip
import com.example.ekar.presentation.component.ComposeHorizontalList
import com.example.ekar.presentation.component.ComposeTextWithBackground
import com.example.ekar.presentation.component.ComposeVehicleAttribute
import com.example.ekar.presentation.component.RichText
import com.example.ekar.presentation.theme.*
import com.example.ekar.presentation.vehicle_detail.Constants.ORIGINAL_VALUE
import com.example.ekar.utils.ConnectionState
import com.example.ekar.utils.UiEvent
import com.example.ekar.utils.calculateMonthlyDiscount
import com.example.ekar.utils.connectivityState
import com.example.ekar.utils.numberFormatWithComma
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun VehicleDetailScreen(
    viewModel: EkarViewModel,
    onNavigateToViewOnBoard: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    val context = LocalContext.current
    val state = viewModel.state

    val connection by connectivityState()

    val isConnected = connection === ConnectionState.Available

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(EkarEvent.OnFetchVehicleDetail(isConnected))
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowToast -> {
                    Toast.makeText(context, event.message.asString(context), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    var sliderValue by remember {
        mutableStateOf(1f) // pass the initial value
    }

    var discountValue by remember {
        mutableStateOf(0f) // pass the initial value
    }

    Scaffold(
        topBar = {
            ActionAppBar(
                title = context.getString(R.string.ekar),
                backEnabled = true,
                ) {
                onNavigateUp()

            }
        },
        modifier = Modifier.fillMaxSize(),
    ) { it ->
        if (!state.isSearching) {
            state.vehicleDetail?.let { vehicleDetail ->
                Column(Modifier.padding(it)) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        item {
                            Column(
                                Modifier
                                    .background(color = LIGHT_BLUE)
                                    .padding(
                                        vertical = MaterialTheme.spacing.view_2x,
                                        horizontal = MaterialTheme.spacing.view_4x
                                    )
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.CenterHorizontally),
                                    painter = painterResource(id = R.drawable.car),
                                    contentDescription = "car"
                                )
                                spacerHeight(height = MaterialTheme.spacing.view_2x)

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Year - ${vehicleDetail.attributes.year}",
                                        style = MaterialTheme.typography.caption,
                                        color = DARK_GREY,
                                        fontWeight = FontWeight.SemiBold,
                                    )

                                    Text(
                                        text = "Made in - ${vehicleDetail.attributes.madeIn}",
                                        style = MaterialTheme.typography.caption,
                                        color = DARK_GREY,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                }
                                spacerHeight(height = MaterialTheme.spacing.view_3x)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            text = "Base Price",
                                            style = MaterialTheme.typography.caption,
                                            color = DARK_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                        RichText(
                                            text1 = "${(ORIGINAL_VALUE - discountValue).numberFormatWithComma()}",
                                            text2 = "AED / MONTH",
                                            text1Style = SpanStyle(
                                                fontSize = MaterialTheme.fontSize.view_30x
                                            )
                                        )
                                    }
                                    Column {
                                        Text(
                                            text = "Contract Length",
                                            style = MaterialTheme.typography.caption,
                                            color = DARK_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                        RichText(
                                            text1 = "${sliderValue.numberFormatWithComma()}",
                                            text2 = "MONTHS",
                                            text1Style = SpanStyle(
                                                fontSize = MaterialTheme.fontSize.view_30x
                                            )
                                        )
                                    }
                                }

                                spacerHeight(height = MaterialTheme.spacing.view_3x)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            text = "Tenure",
                                            style = MaterialTheme.typography.body2,
                                            color = LIGHT_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                        spacerHeight(height = MaterialTheme.spacing.view_1x)
                                        Text(
                                            text = "1 to 9 Months",
                                            style = MaterialTheme.typography.h4,
                                            color = DARK_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                    }
                                    if (discountValue > 0f)
                                        Chip(
                                            modifier = Modifier.padding(MaterialTheme.spacing.view_1x),
                                            onClick = { },
                                            border = BorderStroke(
                                                ChipDefaults.OutlinedBorderSize,
                                                RED
                                            ),
                                            colors = ChipDefaults.chipColors(
                                                backgroundColor = RED,
                                                contentColor = White
                                            )
                                        ) {
                                            Text(
                                                "SAVING OF AED ${discountValue.numberFormatWithComma()}",
                                                color = Color.White,
                                                style = MaterialTheme.typography.caption
                                            )
                                        }
                                }

                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                Slider(
                                    value = sliderValue,
                                    onValueChange = { sliderValue_ ->
                                        sliderValue = sliderValue_
                                        discountValue = calculateMonthlyDiscount(
                                            ORIGINAL_VALUE,
                                            15,
                                            sliderValue.toInt()
                                        )
                                    },
                                    onValueChangeFinished = {
                                    },
                                    colors = SliderDefaults.colors(
                                        thumbColor = BLUE,
                                        activeTrackColor = BLUE
                                    ),
                                    valueRange = 1f..9f,
                                    steps = 2
                                )

                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            text = "Booking Fee",
                                            style = MaterialTheme.typography.caption,
                                            color = DARK_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                        RichText(
                                            text1 = "AED", text2 = "120", text2Style = SpanStyle(
                                                fontSize = MaterialTheme.fontSize.view_30x
                                            )
                                        )
                                    }
                                    ComposeButton(
                                        backgroundColor = Color.White,
                                        textColor = BLUE,
                                        buttonText = "how contract works?",
                                        textStyle = MaterialTheme.typography.caption
                                    ) {
                                        Toast.makeText(
                                            context,
                                            "How Contracts Work?",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .padding(
                                        vertical = MaterialTheme.spacing.view_2x,
                                        horizontal = MaterialTheme.spacing.view_4x
                                    )
                            ) {
                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                Text(
                                    text = stringResource(R.string.About_the_vehicle),
                                    style = MaterialTheme.typography.h3,
                                    color = DARK_GREY,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                FlowRow() {
                                    ComposeVehicleAttribute(
                                        label = "Engine",
                                        value = vehicleDetail.attributes.engine
                                    )
                                    ComposeVehicleAttribute(
                                        label = "Seating",
                                        value = vehicleDetail.attributes.standardSeating
                                    )
                                    ComposeVehicleAttribute(
                                        label = "Fuel Capacity",
                                        value = vehicleDetail.attributes.fuelCapacity
                                    )
                                }

                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                Text(
                                    text = stringResource(R.string.colors),
                                    style = MaterialTheme.typography.h3,
                                    color = DARK_GREY,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                spacerHeight(MaterialTheme.spacing.view_1x)
                                (vehicleDetail.colors).groupBy { it.category }.forEach {
                                    Column {
                                        Text(
                                            text = it.key,
                                            style = MaterialTheme.typography.h5,
                                            color = DARK_GREY,
                                            fontWeight = FontWeight.SemiBold,
                                        )
                                    }
                                    FlowRow {
                                        it.value.forEach { value ->
                                            Chip(
                                                modifier = Modifier.padding(MaterialTheme.spacing.view_1x),
                                                onClick = { },
                                                border = BorderStroke(
                                                    ChipDefaults.OutlinedBorderSize,
                                                    BLUE
                                                ),
                                                colors = ChipDefaults.chipColors(
                                                    backgroundColor = Color.White,
                                                    contentColor = BLUE
                                                )
                                            ) {
                                                Text(value.name)
                                            }

                                        }
                                    }
                                }
                                spacerHeight(height = MaterialTheme.spacing.view_2x)

                                Text(
                                    text = stringResource(R.string.key_features),
                                    style = MaterialTheme.typography.h3,
                                    color = DARK_GREY,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                FlowRow() {
                                    if (vehicleDetail.equipment.adjustableFootPedals == "Std.") ComposeChip(
                                        value = "Adjustable foot pedals"
                                    )
                                    if (vehicleDetail.equipment.airConditioning == "Std.") ComposeChip(
                                        value = "Air conditioning"
                                    )
                                    if (vehicleDetail.equipment.alloyWheels == "Std.") ComposeChip(
                                        value = "Alloy wheels"
                                    )
                                    if (vehicleDetail.equipment.cargoAreaCover == "Std.") ComposeChip(
                                        value = "Cargo area cover"
                                    )
                                    if (vehicleDetail.equipment.childSafetyDoorLocks == "Std.") ComposeChip(
                                        value = "Child safety door locks"
                                    )
                                    if (vehicleDetail.equipment.cruiseControl == "Std.") ComposeChip(
                                        value = "Cruise control"
                                    )
                                }

                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                Text(
                                    text = stringResource(R.string.warranties),
                                    style = MaterialTheme.typography.h3,
                                    color = DARK_GREY,
                                    fontWeight = FontWeight.SemiBold,
                                )
                                spacerHeight(height = MaterialTheme.spacing.view_2x)
                                ComposeHorizontalList(list = vehicleDetail.warranties) { item, index ->
                                    ComposeTextWithBackground(warranty = item)
                                }
                            }

                        }

                    }

                    Footer(vehicleDetail, onNavigateToViewOnBoard)
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    color = Color.Black,
                    strokeWidth = MaterialTheme.spacing.view_1x
                )
            }
        }
    }
}

@Composable
private fun Footer(
    vehicleDetail: VehicleDetail,
    onNavigateToViewOnBoard: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.view_8x)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(MaterialTheme.spacing.view_8x),
                    painter = painterResource(id = R.drawable.car_logo),
                    contentDescription = "car_logo"
                )
                spacerWidth(width = MaterialTheme.spacing.view_2x)
                Column {
                    RichText(
                        text1 = vehicleDetail.attributes.make,
                        text2 = vehicleDetail.attributes.model,
                        text1Style = SpanStyle(
                            fontSize = MaterialTheme.fontSize.view_24x, fontWeight = FontWeight.Bold
                        ), text2Style = SpanStyle(
                            fontSize = MaterialTheme.fontSize.view_24x,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    Text(
                        text = vehicleDetail.attributes.style,
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
            spacerHeight(height = MaterialTheme.spacing.view_2x)
            ComposeButton(
                modifier = Modifier.fillMaxWidth(),
                buttonText = "Proceed with your selection",
                innerPadding = MaterialTheme.spacing.view_2x
            ) {
                onNavigateToViewOnBoard()
            }
        }
    }
}

private object Constants {
    const val ORIGINAL_VALUE = 3000
}