package com.example.sweetrealm.presentation.category_detail

sealed class CategoryDetailEvent{
    data class OnSearchQuery(val query: String): CategoryDetailEvent()
}
