package com.example.sweetrealm.presentation.home

import android.view.WindowInsets
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
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
            val mostPopularFlow = repository.getAllItem().flowOn(Dispatchers.IO)
            combine(
                favoritesFlow,
                newlyAddedFlow,
                mostPopularFlow
            ) { favorites, newlyAdded, mostPopular ->
                Triple(favorites, newlyAdded, mostPopular)
            }.collect { (favorites, newlyAdded, mostPopular) ->
                if (favorites.isNotEmpty() || newlyAdded.isNotEmpty() || mostPopular.isNotEmpty()) {
                    state = state.copy(
                        newlyAddedList = newlyAdded,
                        mostPreferredList = mostPopular.subList(8,15),
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