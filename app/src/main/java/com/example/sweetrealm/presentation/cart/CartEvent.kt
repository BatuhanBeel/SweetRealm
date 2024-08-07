package com.example.sweetrealm.presentation.cart

import com.example.sweetrealm.domain.model.SweetCart

sealed class CartEvent {
    data class OnCheckboxClick(val item: SweetCart) : CartEvent()
    data class OnIncreaseClick(val item: SweetCart): CartEvent()
    data class OnDecreaseClick(val item: SweetCart): CartEvent()
    data object OnDeleteAllClick: CartEvent()
    data object OnGoToCheckoutClick: CartEvent()
}
