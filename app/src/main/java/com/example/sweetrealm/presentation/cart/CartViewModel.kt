package com.example.sweetrealm.presentation.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: SweetRealmRepository
) : ViewModel() {

    var cartState = mutableStateOf(CartState())
    var price by mutableFloatStateOf(
        cartState.value.shoppingList
        .filter { it.isSelected }
        .map { it.price }
        .sum()
    )

    init {
        getCartItems()
    }

    private fun getCartItems() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCartItems().collect {
                cartState.value = cartState.value.copy(
                    shoppingList = it,
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: CartEvent){
        when(event){
            is CartEvent.OnSelectClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    val item = repository.getCartItem(event.itemId)
                    item?.let {
                        repository.insertCartItem(
                            it.copy(
                                isSelected = !it.isSelected
                            )
                        )
                    }
                }
            }
            is CartEvent.OnIncreaseClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    val item = repository.getCartItem(event.itemId)
                    item?.let {
                        repository.insertCartItem(
                            it.copy(
                                count = it.count + 1
                            )
                        )
                    }
                }
            }
            is CartEvent.OnDecreaseClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    val item = repository.getCartItem(event.itemId)
                    item?.let {
                        repository.insertCartItem(
                            it.copy(
                                count = it.count - 1
                            )
                        )
                    }
                }
            }
            is CartEvent.OnDeleteAllClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.de
                }
            }
        }

    }


}