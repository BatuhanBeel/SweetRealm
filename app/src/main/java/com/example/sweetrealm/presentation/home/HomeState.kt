package com.example.sweetrealm.presentation.home

import com.example.sweetrealm.domain.model.Sweet

data class HomeState(
    val favoritesList: List<Sweet> = emptyList(),
    val mostPreferredList: List<Sweet> = emptyList(),
    val newlyAddedList: List<Sweet> = emptyList()
)