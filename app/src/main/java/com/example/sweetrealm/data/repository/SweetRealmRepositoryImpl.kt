package com.example.sweetrealm.data.repository

import com.example.sweetrealm.data.data_source.SweetDao
import com.example.sweetrealm.domain.SweetRealmRepository
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import kotlinx.coroutines.flow.Flow

class SweetRealmRepositoryImpl(
    private val dao: SweetDao
): SweetRealmRepository {
    override suspend fun insertSweetItem(item: Sweet) {
        dao.insertSweetItem(item)
    }

    override fun getItemsFilterByNew(): Flow<List<Sweet>> {
        return dao.getItemsFilterByNew()
    }

    override fun getItemsFilterByFavorite(): Flow<List<Sweet>> {
        return dao.getItemsFilterByFavorite()
    }

    override fun getItemsFilterByCategory(category: String): Flow<List<Sweet>> {
        return dao.getItemsFilterByCategory(category)
    }

    override fun getItemById(itemId: Int): Sweet {
        return dao.getItemById(itemId)
    }

    override suspend fun itemFavoriteClicked(item: Sweet) {
        dao.insertSweetItem(item)
    }

    override suspend fun deleteAllItem() {
        dao.deleteAllItem()
    }

    override fun getCartItem(itemId: Int): SweetCart {
        return dao.getCartItemById(itemId)
    }

    override suspend fun insertCartItem(item: SweetCart) {
        dao.insertCartItem(item)
    }
}