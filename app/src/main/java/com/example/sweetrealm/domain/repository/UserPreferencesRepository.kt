package com.example.sweetrealm.domain.repository

import com.example.sweetrealm.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {

    fun fetchUserPreferences(): Flow<UserPreferences>

    suspend fun updateUserPreferences()
}