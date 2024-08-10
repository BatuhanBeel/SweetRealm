package com.example.sweetrealm.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.sweetrealm.R
import com.example.sweetrealm.di.DataModule
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.domain.model.SweetCart
import com.example.sweetrealm.domain.model.SweetCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Sweet::class, SweetCategory::class, SweetCart::class], version = 2)
abstract class SweetRealmDatabase(): RoomDatabase() {
    abstract fun getDao(): SweetDao

    class Callback @Inject constructor(
        private val database: Provider<SweetRealmDatabase>,
        @DataModule.ApplicationScope private val scope: CoroutineScope
    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().getDao()

            scope.launch(Dispatchers.IO){
                dao.insertItem(Sweet(0,"Cake", R.drawable.cake, 10f, "Cake" ,"", "", isFavorite = false, isNew = true))
            }

        }
    }
}
