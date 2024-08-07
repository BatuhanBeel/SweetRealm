package com.example.sweetrealm.presentation.cart

sealed class CartEvent {
    data class OnSelectClick(val itemId: Int) : CartEvent()
    data class OnIncreaseClick(val itemId: Int): CartEvent()
    data class OnDecreaseClick(val itemId: Int): CartEvent()
    data object OnDeleteAllClick: CartEvent()
    data object OnGoToCheckoutClick: CartEvent()
}
