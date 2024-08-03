package com.example.sweetrealm.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCategory

@Database(entities = [Sweet::class, SweetCategory::class], version = 1)
abstract class SweetRealmDatabase(): RoomDatabase() {
    abstract val dao: SweetDao
}