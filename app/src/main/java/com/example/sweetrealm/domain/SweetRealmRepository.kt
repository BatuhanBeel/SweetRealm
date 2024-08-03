package com.example.sweetrealm.domain

import com.example.sweetrealm.domain.model.Sweet
import kotlinx.coroutines.flow.Flow

interface SweetRealmRepository {

    suspend fun insertItem(item: Sweet)

    fun getItemById(itemId: Int): Sweet

    fun getItemsFilterByNew(): Flow<List<Sweet>>

    fun getItemsFilterByFavorite(): Flow<List<Sweet>>

    fun getItemsFilterByCategory(category: String): Flow<List<Sweet>>

    suspend fun itemFavoriteClicked(item: Sweet)

    suspend fun deleteAllItem()
}