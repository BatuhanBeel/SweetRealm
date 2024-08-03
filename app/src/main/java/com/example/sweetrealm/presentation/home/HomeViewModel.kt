package com.example.sweetrealm.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SweetRealmRepository
): ViewModel() {

    fun itemClickedFavorite(itemId: Int){
        viewModelScope.launch(Dispatchers.IO){
            val item = repository.getItemById(itemId)
            repository.itemFavoriteClicked(
                item.copy(
                    isFavorite = !item.isFavorite
                )
            )
        }
    }

}