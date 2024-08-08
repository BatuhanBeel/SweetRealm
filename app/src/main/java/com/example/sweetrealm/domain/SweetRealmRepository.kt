package com.example.sweetrealm.domain

import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import com.example.sweetrealm.domain.model.SweetCategory
import kotlinx.coroutines.flow.Flow

interface SweetRealmRepository {

    // Home

    fun getAllItem(): Flow<List<Sweet>>

    fun getItemsByName(name: String): Flow<List<Sweet>>

    suspend fun insertSweetItem(item: Sweet)

    fun getItemById(itemId: Int): Sweet

    fun getItemsFilterByNew(): Flow<List<Sweet>>

    fun getItemsFilterByFavorite(): Flow<List<Sweet>>

    fun getItemsFilterByCategory(category: String): Flow<List<Sweet>>

    suspend fun itemFavoriteClicked(item: Sweet)

    suspend fun deleteAllItem()

    // Categories

    fun getAllCategories(): Flow<List<SweetCategory>>

    // Cart

    fun getAllCartItems(): Flow<List<SweetCart>>

    fun getCartItem(itemId: Int): SweetCart?

    suspend fun insertCartItem(item: SweetCart)

    suspend fun deleteCartItem(item: SweetCart)

    suspend fun deleteAllCartItem()
}
