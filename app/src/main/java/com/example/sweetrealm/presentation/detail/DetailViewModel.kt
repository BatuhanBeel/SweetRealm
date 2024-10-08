package com.example.sweetrealm.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import com.example.sweetrealm.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: SweetRealmRepository
): ViewModel() {

    private var _sweet = MutableStateFlow<Sweet?>(null)
    val sweet = _sweet.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    private var sweetId: Int = 0
    var quantity by mutableIntStateOf(0)


    fun loadSweet(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            sweetId = id
            _sweet.value = repository.getItemById(id)
        }
    }

    fun onEvent(event: DetailEvent){
        when(event){
            is DetailEvent.OnFavoriteClick -> {
                onFavoriteClicked()
            }
            is DetailEvent.OnIncreaseClick -> {
                if (quantity < 10){
                    quantity++
                }
            }
            is DetailEvent.OnDecreaseClick -> {
                if (0 < quantity){
                    quantity--
                }
            }
            is DetailEvent.AddToCardClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _sweet.value?.let {
                        val cartItem = repository.getCartItem(it.id)
                        if (cartItem != null){
                            repository.insertCartItem(
                                cartItem.copy(
                                    count = cartItem.count + quantity
                                )
                            )
                        } else{
                            repository.insertCartItem(
                                SweetCart(
                                    id = it.id,
                                    name = it.name,
                                    imageUrl = it.imageUrl,
                                    price = it.price,
                                    count = quantity
                                )
                            )
                        }
                        _eventFlow.emit(UiEvent.ShowSnackbar("Dessert added to card"))
                    }
                }
            }
        }
    }

    private fun onFavoriteClicked(){
        viewModelScope.launch(Dispatchers.IO){
            _sweet.value?.let {
                repository.insertSweetItem(
                    it.copy(
                        isFavorite = !it.isFavorite
                    )
                )
            }
            _sweet.value = repository.getItemById(sweetId)
        }
    }
}