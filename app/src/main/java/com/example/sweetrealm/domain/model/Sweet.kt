package com.example.sweetrealm.domain.model

data class Sweet(
    val id: Int = 0 ,
    val name: String,
    val image: Int,
    val price: Float,
    val details: String,
    val ingredients: String,
    val isFavorite: Boolean = false,
    val isNew: Boolean = false
)
