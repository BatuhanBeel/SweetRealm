package com.example.sweetrealm.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.Home
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SweetRealmRepository
) : ViewModel() {


    var state by mutableStateOf(HomeState())
        private set

    init {
        getInitialData()
    }

    private fun getInitialData() {
        viewModelScope.launch {
            val favoritesFlow = repository.getItemsFilterByFavorite().flowOn(Dispatchers.IO)
            val newlyAddedFlow = repository.getItemsFilterByNew().flowOn(Dispatchers.IO)
            combine(
                favoritesFlow,
                newlyAddedFlow
            ) { favorites, newlyAdded ->
                Pair(favorites, newlyAdded)
            }.collect { (favorites, newlyAdded) ->
                if (favorites.isNotEmpty() || newlyAdded.isNotEmpty()) {
                    state = state.copy(
                        newlyAddedList = newlyAdded,
                        favoritesList = favorites
                    )
                }
            }
        }
    }


    fun itemClickedFavorite(itemId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = repository.getItemById(itemId)
            repository.itemFavoriteClicked(
                item.copy(
                    isFavorite = !item.isFavorite
                )
            )
        }
    }

}