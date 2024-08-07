package com.example.sweetrealm.presentation.cart

import com.example.sweetrealm.domain.model.SweetCart

data class CartState(
    val isLoading: Boolean = true,
    var shoppingList: List<SweetCart> = emptyList()
)
