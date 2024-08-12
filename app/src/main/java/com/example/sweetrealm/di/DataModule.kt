package com.example.sweetrealm.di

import android.content.Context
import androidx.room.Room
import com.example.sweetrealm.data.data_source.SweetDao
import com.example.sweetrealm.data.data_source.SweetRealmDatabase
import com.example.sweetrealm.data.repository.SweetRealmRepositoryImpl
import com.example.sweetrealm.domain.repository.SweetRealmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        callback: SweetRealmDatabase.Callback
    ) = Room.databaseBuilder(
        context = context,
        SweetRealmDatabase::class.java,
        "sweet_realm.db")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    @Singleton
    fun provideDao(db: SweetRealmDatabase): SweetDao = db.getDao()

    @Provides
    @Singleton
    fun provideSpendingRepository(db: SweetRealmDatabase): SweetRealmRepository =
        SweetRealmRepositoryImpl(db.getDao())

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope(): CoroutineScope = CoroutineScope(SupervisorJob())

    @Retention
    @Qualifier
    annotation class ApplicationScope
}