package com.example.sweetrealm.presentation.category_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    val repository: SweetRealmRepository
) : ViewModel() {

    var categoryDetailState by mutableStateOf(CategoryDetailState())
        private set

    private var categoryList by mutableStateOf(listOf<Sweet>())

    var query by mutableStateOf("")
        private set

    private var job: Job? = null

    fun getSweets(category: String) {
        viewModelScope.launch {
            val items = repository.getItemsFilterByCategory(category).flowOn(Dispatchers.IO)
            items.collect {
                if (it.isNotEmpty()) {
                    categoryList = it
                    categoryDetailState = categoryDetailState.copy(
                        sweets = it
                    )
                }
            }
        }
    }

    fun onEvent(event: CategoryDetailEvent) {
        when (event) {
            is CategoryDetailEvent.OnSearchQuery -> {
                query = event.query
                if (event.query.isNotEmpty()){
                    searchSweets(event.query)
                }
                else{
                    categoryDetailState = categoryDetailState.copy(
                        sweets = categoryList
                    )
                }
            }
        }
    }

    private fun searchSweets(query: String) {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.Default) {
            val items = categoryList.filter { it.name.contains(query, ignoreCase = true) }
            withContext(Dispatchers.Main){
                categoryDetailState = categoryDetailState.copy(
                    sweets = items
                )
            }
        }
    }

}