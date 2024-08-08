package com.example.sweetrealm.presentation.category_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    val repository: SweetRealmRepository
): ViewModel() {

    var categoryDetailState by mutableStateOf(CategoryDetailState())
        private set

    var query by mutableStateOf("")
        private set

    var job: Job? = null

    fun getSweets(category: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getItemsFilterByCategory(category).collect{
                if (it.isNotEmpty()){
                    categoryDetailState = categoryDetailState.copy(
                        sweets = it
                    )
                }
            }
        }
    }

    fun onEvent(event: CategoryDetailEvent){
        when(event){
            is CategoryDetailEvent.OnSearchQuery ->{
                searchSweets(event.query)
            }
        }
    }

    private fun searchSweets(query: String){
        job?.cancel()
        job = repository.getItemsByName(query).onEach {
            if (it.isNotEmpty()){
                categoryDetailState = categoryDetailState.copy(
                    sweets = it
                )
            }
        }.launchIn(viewModelScope)
    }

}