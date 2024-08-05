package com.example.sweetrealm.domain

import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import kotlinx.coroutines.flow.Flow

interface SweetRealmRepository {

    suspend fun insertSweetItem(item: Sweet)

    fun getItemById(itemId: Int): Sweet

    fun getItemsFilterByNew(): Flow<List<Sweet>>

    fun getItemsFilterByFavorite(): Flow<List<Sweet>>

    fun getItemsFilterByCategory(category: String): Flow<List<Sweet>>

    suspend fun itemFavoriteClicked(item: Sweet)

    suspend fun deleteAllItem()

// Cart
    fun getCartItem(itemId: Int): SweetCart?

    suspend fun insertCartItem(item: SweetCart)
}
