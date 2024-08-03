package com.example.sweetrealm.di

import android.content.Context
import androidx.room.Room
import com.example.sweetrealm.data.data_source.SweetDao
import com.example.sweetrealm.data.data_source.SweetRealmDatabase
import com.example.sweetrealm.data.repository.SweetRealmRepositoryImpl
import com.example.sweetrealm.domain.SweetRealmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        SweetRealmDatabase::class.java,
        "sweet_realm.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: SweetRealmDatabase): SweetDao = db.dao

    @Provides
    @Singleton
    fun provideSpendingRepository(db: SweetRealmDatabase): SweetRealmRepository =
        SweetRealmRepositoryImpl(db.dao)
}