package com.example.sweetrealm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class SweetCart(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Float,
    val count: Int,
    val isSelected: Boolean = true
)
