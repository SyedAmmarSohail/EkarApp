package com.example.ekar.presentation

sealed class EkarEvent {
    data class OnFetchVehicleDetail(val isConnected: Boolean) : EkarEvent()
}
