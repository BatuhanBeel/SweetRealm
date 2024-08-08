package com.example.sweetrealm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("category_table")
data class SweetCategory(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Int,
)
