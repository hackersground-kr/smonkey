package com.saehyun.data.repository

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.saehyun.data.local.datastore
import com.saehyun.data.network.user.SignInRequest
import com.saehyun.data.network.user.SignUpRequest
import com.saehyun.data.network.user.UserAPI
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userAPI: UserAPI,
    private val context: Context,
) : UserRepository {
    override suspend fun signIn(request: SignInRequest) {
        userAPI.signIn(request).content.apply {
            saveToken(accessToken, refreshToken)
        }
    }

    override suspend fun signUp(request: SignUpRequest) {
        userAPI.signUp(request).content.apply {
            saveToken(accessToken, refreshToken)
        }
    }

    private suspend fun saveToken(
        accessToken: String,
        refreshToken: String
    ) {
        context.datastore.edit { preference ->
            preference[ACCESS_TOKEN] = accessToken
            preference[REFRESH_TOKEN] = refreshToken
        }
    }

    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }
}