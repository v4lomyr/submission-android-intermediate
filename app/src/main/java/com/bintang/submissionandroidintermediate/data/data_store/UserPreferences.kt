package com.bintang.submissionandroidintermediate.data.data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.bintang.submissionandroidintermediate.data.api_call_response.LoginResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {
    val userToken: Flow<String> = dataStore.data.map { preferences ->
        preferences[USER_TOKEN] ?: ""
    }

    suspend fun saveUserData(data: LoginResult){
        dataStore.edit { preferences ->
            preferences[USER_ID] = data.userId
            preferences[USER_NAME] = data.name
            preferences[USER_TOKEN] = data.token
        }
    }

    suspend fun clearUserData(){
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        val USER_ID = stringPreferencesKey("user_id")
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_TOKEN = stringPreferencesKey("user_token")

        @Volatile
        private var INSTANCE: UserPreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}