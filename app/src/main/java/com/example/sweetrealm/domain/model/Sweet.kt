package com.example.sweetrealm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sweet_table")
data class Sweet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val price: Float,
    val category: String,
    val country: String,
    val ingredients: String,
    val isFavorite: Boolean = false,
    val isNew: Boolean = false
)
