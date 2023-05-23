package com.example.ekar.presentation

import android.location.Location
import com.example.ekar.data.remote.dto.VehicleDetail


data class EkarUiState(
    val lastKnownLocation: Location? = null,
    val isSearching: Boolean = false,
    val vehicleDetail: VehicleDetail? = null
)
