package com.example.sweetrealm.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.sweetrealm.domain.repository.UserPreferencesRepository
import com.example.sweetrealm.data.util.PreferencesKeys
import com.example.sweetrealm.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserPreferencesRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): UserPreferencesRepository {

    override fun fetchUserPreferences(): Flow<UserPreferences> =
        dataStore.data.map { preferences ->
            val initial = preferences[PreferencesKeys.INITIAL] ?: true
            UserPreferences(initial)
        }


    override suspend fun updateUserPreferences() {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.INITIAL] = false
            }
        } catch (e: IOException) {
            Log.d("DataStore", e.message.toString())
        }
    }
}