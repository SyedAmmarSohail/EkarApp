package com.example.ekar.utils

sealed class UiEvent {
    data class ShowToast(val message: UiText) : UiEvent()
}
