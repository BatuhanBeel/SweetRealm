package com.example.sweetrealm.presentation.category

import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCategory

data class CategoryState(
    val categories: List<SweetCategory> = emptyList(),
    val sweets: List<Sweet> = emptyList()
)
