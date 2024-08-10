package com.example.sweetrealm.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import com.example.sweetrealm.domain.model.SweetCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface SweetDao {
    //Home
    @Query("SELECT * FROM sweet_table")
    fun getAllItem(): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE :itemId == id")
    fun getItemById(itemId: Int): Sweet

    @Query("SELECT * FROM sweet_table WHERE name LIKE '%' || :name || '%'")
    fun getItemsByName(name: String): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE isNew == 1 ")
    fun getItemsFilterByNew(): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE isFavorite == 1")
    fun getItemsFilterByFavorite(): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE :category == category")
    fun getItemsFilterByCategory(category: String): Flow<List<Sweet>>

    @Upsert
    suspend fun insertItem(item: Sweet)

    @Query("DELETE FROM sweet_table ")
    suspend fun deleteAllItem()

    @Delete
    suspend fun deleteItem(item: Sweet)

    //Categories
    @Query("SELECT * FROM category_table")
    fun getAllCategories(): Flow<List<SweetCategory>>


    // Cart
    @Query("SELECT * FROM cart_table")
    fun getAllCartItem(): Flow<List<SweetCart>>

    @Query("SELECT * FROM cart_table WHERE :itemId == id")
    fun getCartItemById(itemId: Int): SweetCart

    @Upsert
    suspend fun insertCartItem(item: SweetCart)

    @Query("DELETE FROM cart_table")
    suspend fun deleteAllCartItem()

    @Delete
    suspend fun deleteCartItem(item: SweetCart)

}