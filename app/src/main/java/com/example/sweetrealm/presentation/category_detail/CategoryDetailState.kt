package com.example.sweetrealm.presentation.category_detail

import com.example.sweetrealm.domain.model.Sweet

data class CategoryDetailState(
    val sweets: List<Sweet> = emptyList()
)