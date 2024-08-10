package com.example.sweetrealm.presentation.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: SweetRealmRepository
): ViewModel(){

    var categoryState by mutableStateOf(CategoryState())
        private set

    init {
        getCategories()
        getSweets()
    }

    private fun getCategories(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCategories().collect { it ->
                if (it.isNotEmpty()){
                    categoryState = categoryState.copy(
                        categories = it
                    )
                }
            }
        }
    }

    private fun getSweets(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllItem().collect {
                if (it.isNotEmpty()){
                    categoryState = categoryState.copy(
                        sweets = it
                    )
                }
            }
        }
    }



}