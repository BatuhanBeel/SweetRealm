package com.example.sweetrealm.presentation.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: SweetRealmRepository
) : ViewModel() {

    var cartState by mutableStateOf(CartState())

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        viewModelScope.launch {
            val items = repository.getAllCartItems().flowOn(Dispatchers.IO)
            items.collect {
                if(it.isNotEmpty()){
                    cartState = cartState.copy(
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