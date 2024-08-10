package com.example.sweetrealm.presentation.cart

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: SweetRealmRepository
) : ViewModel() {

    var cartState = mutableStateOf(CartState())
    var price = mutableFloatStateOf(
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
                if(it.isNotEmpty()){
                    cartState.value = cartState.value.copy(
                        shoppingList = it,
                        isLoading = false
                    )
                }
            }
        }
    }

    fun onEvent(event: CartEvent){
        when(event){
            is CartEvent.OnCheckboxClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    repository.insertCartItem(
                        event.item.copy(
                            isSelected = !event.item.isSelected
                        )
                    )
                }
            }
            is CartEvent.OnIncreaseClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    repository.insertCartItem(
                        event.item.copy(
                            count = event.item.count + 1
                        )
                    )
                }
            }
            is CartEvent.OnDecreaseClick ->{
                viewModelScope.launch(Dispatchers.IO) {
                    repository.insertCartItem(
                        event.item.copy(
                            count = event.item.count - 1
                        )
                    )
                }
            }
            is CartEvent.OnDeleteAllClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteAllCartItem()
                }
            }
            is CartEvent.OnGoToCheckoutClick -> {

            }
        }

    }
}