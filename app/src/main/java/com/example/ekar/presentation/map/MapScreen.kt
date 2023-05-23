package com.example.ekar.presentation.map

import android.content.Context
import android.graphics.Bitmap
import android.location.Location
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.ekar.R
import com.example.ekar.presentation.EkarViewModel
import com.example.ekar.presentation.component.ActionAppBar
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(
    viewModel: EkarViewModel,
    onNavigateToDetail: () -> Unit
) {

    val context = LocalContext.current

    val defaultLocation = Location("")
    defaultLocation.latitude = 33.738045
    defaultLocation.longitude = 73.084488

    var updatedLocation by remember {
        mutableStateOf<Location?>(null)
    }

    GpsAndLocationPermissionRequest { location ->
        updatedLocation = location ?: defaultLocation
    }

    val mapProperties = MapProperties(
        isMyLocationEnabled = updatedLocation != null,
    )

    val cameraPositionState = rememberCameraPositionState()

    LaunchedEffect(updatedLocation) {
        updatedLocation?.let {
            cameraPositionState.animate(
                update = CameraUpdateFactory.newCameraPosition(
                    CameraPosition(LatLng(it.latitude, it.longitude), 13f, 0f, 0f)
                ),
            )
        }
    }

    Scaffold(
        topBar = {
            ActionAppBar(
                title = context.getString(R.string.ekar),
                backEnabled = false,
                ) {
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                properties = mapProperties,
                cameraPositionState = cameraPositionState
            ) {
                val context = LocalContext.current

                updatedLocation?.let { location ->
                    Marker(
                        state = rememberMarkerState(
                            position = LatLng(
                                location.latitude,
                                location.longitude
                            )
                        ),
                        icon = bitmapDescriptorFromVector(
                            context, R.drawable.icn_marker
                        ),
                        onClick = {
                            onNavigateToDetail()
                            true
                        },
                        draggable = true
                    )


                    MarkerInfoWindow(
                        state = rememberMarkerState(
                            position = LatLng(
                                location.latitude,
                                location.longitude
                            )
                        ),
                        icon = bitmapDescriptorFromVector(
                            context, R.drawable.icn_marker
                        ),
                        onClick = {
                            onNavigateToDetail()
                            true
                        },
                        draggable = true
                    )
                }
            }
        }
    }
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}
