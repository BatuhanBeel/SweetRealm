package com.example.sweetrealm.presentation.detail

sealed class DetailEvent {
    data object OnFavoriteClick: DetailEvent()
    data object OnIncreaseClick: DetailEvent()
    data object OnDecreaseClick: DetailEvent()
    data object AddToCardClick: DetailEvent()
}