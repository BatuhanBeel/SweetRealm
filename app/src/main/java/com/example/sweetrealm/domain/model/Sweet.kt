package com.example.sweetrealm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sweet_table")
data class Sweet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ,
    val name: String,
    val image: Int,
    val price: Float,
    val category: String,
    val details: String,
    val ingredients: String,
    val isFavorite: Boolean = false,
    val isNew: Boolean = false
)
