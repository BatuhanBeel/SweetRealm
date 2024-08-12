package com.example.sweetrealm.presentation.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: SweetRealmRepository
): ViewModel(){

    var state by mutableStateOf(CategoryState())
        private set

    init {
        loadData()
    }

    private fun loadData(){
        viewModelScope.launch {
            val categoriesFlow = repository.getAllCategories().flowOn(Dispatchers.IO)
            val sweetsFlow = repository.getAllItem().flowOn(Dispatchers.IO)
            combine(
                categoriesFlow,
                sweetsFlow
            ) { categories, sweets ->
                Pair(categories, sweets)
            }.collect { (categories, sweets) ->
                if (categories.isNotEmpty() || sweets.isNotEmpty()) {
                    state = state.copy(
                        categories = categories,
                        sweets = sweets
                    )
                }
            }
        }
    }
}