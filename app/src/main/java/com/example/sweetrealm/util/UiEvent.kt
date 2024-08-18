package com.example.sweetrealm.util

sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
}


