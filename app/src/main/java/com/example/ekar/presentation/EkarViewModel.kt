package com.example.ekar.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ekar.R
import com.example.ekar.domain.usecase.VehicleDetailUsecase
import com.example.ekar.utils.*
import com.example.ekar.utils.succeeded
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EkarViewModel @Inject constructor(
    private val vehicleDetailUsecase: VehicleDetailUsecase,
) : ViewModel() {

    var state by mutableStateOf(
        EkarUiState(
            isSearching = true
        )
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(ekarEvent: EkarEvent) {
        when (ekarEvent) {
            is EkarEvent.OnFetchVehicleDetail -> fetchVehicleDetail(
                ekarEvent.isConnected
            )
        }
    }

    private fun fetchVehicleDetail(isConnected: Boolean) {
        if (isConnected)
            fetchVehicleDetail()
        else {
            viewModelScope.launch {
                state = state.copy(
                    isSearching = false
                )
                _uiEvent.send(UiEvent.ShowToast(UiText.StringResource(R.string.network_error)))
            }
        }
    }

    private fun fetchVehicleDetail() {
        state = state.copy(isSearching = true)
        viewModelScope.launch {
            val response = vehicleDetailUsecase.invoke()
            if (response.succeeded()) {
                state = state.copy(
                    isSearching = false,
                    vehicleDetail = response.data
                )
            } else {
                state = state.copy(
                    isSearching = false
                )
                _uiEvent.send(UiEvent.ShowToast(UiText.StringResource(R.string.service_fetch_error)))
            }
        }
    }
}