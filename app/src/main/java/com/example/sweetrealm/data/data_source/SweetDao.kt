package com.example.sweetrealm.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import kotlinx.coroutines.flow.Flow

@Dao
interface SweetDao {

    @Query("SELECT * FROM sweet_table WHERE :itemId == id")
    fun getItemById(itemId: Int): Sweet

    @Query("SELECT * FROM sweet_table WHERE isNew")
    fun getItemsFilterByNew(): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE isFavorite")
    fun getItemsFilterByFavorite(): Flow<List<Sweet>>

    @Query("SELECT * FROM sweet_table WHERE :category == category")
    fun getItemsFilterByCategory(category: String): Flow<List<Sweet>>

    @Upsert
    suspend fun insertSweetItem(item: Sweet)

    @Query("DELETE FROM sweet_table ")
    suspend fun deleteAllItem()

    @Delete
    suspend fun deleteItem(item: Sweet)

    @Query("SELECT * FROM cart_table")
    fun getAllCartItem(): Flow<List<SweetCart>>

    @Query("SELECT * FROM cart_table WHERE :itemId == id")
    fun getCartItemById(itemId: Int): SweetCart

    @Upsert
    suspend fun insertCartItem(item: SweetCart)

}