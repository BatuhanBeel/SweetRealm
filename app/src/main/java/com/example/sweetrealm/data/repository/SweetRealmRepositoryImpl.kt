package com.example.sweetrealm.data.repository

import com.example.sweetrealm.data.data_source.SweetDao
import com.example.sweetrealm.domain.SweetRealmRepository
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import com.example.sweetrealm.domain.model.SweetCategory
import kotlinx.coroutines.flow.Flow

class SweetRealmRepositoryImpl(
    private val dao: SweetDao
): SweetRealmRepository {

    override fun getAllItem(): Flow<List<Sweet>> {
        return dao.getAllItem()
    }

    override fun getItemsByName(name: String): Flow<List<Sweet>> {
        return dao.getItemsByName(name)
    }

    override suspend fun insertSweetItem(item: Sweet) {
        dao.insertItem(item)
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
        dao.insertItem(item)
    }

    override suspend fun deleteAllItem() {
        dao.deleteAllItem()
    }

    //Categories
    override fun getAllCategories(): Flow<List<SweetCategory>> {
        return dao.getAllCategories()
    }

    //Cart
    override fun getAllCartItems(): Flow<List<SweetCart>> {
        return dao.getAllCartItem()
    }

    override fun getCartItem(itemId: Int): SweetCart {
        return dao.getCartItemById(itemId)
    }

    override suspend fun insertCartItem(item: SweetCart) {
        dao.insertCartItem(item)
    }

    override suspend fun deleteCartItem(item: SweetCart) {
        dao.deleteCartItem(item)
    }

    override suspend fun deleteAllCartItem() {
        dao.deleteAllCartItem()
    }
}