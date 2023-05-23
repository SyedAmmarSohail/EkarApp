package com.example.ekar.presentation.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@Composable
fun GpsAndLocationPermissionRequest(onLocationReceived: (Location?) -> Unit) {
    val context = LocalContext.current
    val fusedLocationClient =
        remember(context) { LocationServices.getFusedLocationProviderClient(context) }
    var locationPermissionState by remember {
        mutableStateOf<LocationPermissionState>(
            LocationPermissionState.Initial
        )
    }
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            locationPermissionState = if (isGranted) {
                LocationPermissionState.Granted
            } else {
                LocationPermissionState.Denied
            }
            if (isGranted) {
                requestLocationUpdates(fusedLocationClient, onLocationReceived)
            }
        }
    )

    LaunchedEffect(locationPermissionState) {
        when (locationPermissionState) {
            LocationPermissionState.Initial -> {
                locationPermissionState = getLocationPermissionState(context)
            }
            LocationPermissionState.RequestPermission -> {
                locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
            LocationPermissionState.Granted -> {
                requestLocationUpdates(fusedLocationClient, onLocationReceived)
            }
            LocationPermissionState.Denied -> {
                // Handle the denied state, show a message or request permission again
            }
        }
    }
}

private fun getLocationPermissionState(context: Context): LocationPermissionState {
    return if (hasLocationPermission(context)) {
        LocationPermissionState.Granted
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            LocationPermissionState.RequestPermission
        } else {
            LocationPermissionState.Denied
        }
    }
}

private fun hasLocationPermission(context: Context): Boolean {
    val finePermission = Manifest.permission.ACCESS_FINE_LOCATION
    val coarsePermission = Manifest.permission.ACCESS_COARSE_LOCATION

    return (ContextCompat.checkSelfPermission(
        context,
        finePermission
    ) == PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                context,
                coarsePermission
            ) == PackageManager.PERMISSION_GRANTED)
}

sealed class LocationPermissionState {
    object Initial : LocationPermissionState()
    object RequestPermission : LocationPermissionState()
    object Granted : LocationPermissionState()
    object Denied : LocationPermissionState()
}

@SuppressLint("MissingPermission")
private fun requestLocationUpdates(
    fusedLocationClient: FusedLocationProviderClient,
    onLocationReceived: (Location?) -> Unit
) {
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            onLocationReceived(location)
    }
}