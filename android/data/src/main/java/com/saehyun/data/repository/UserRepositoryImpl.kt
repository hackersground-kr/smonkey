package com.saehyun.data.repository

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.saehyun.data.local.datastore
import com.saehyun.data.local.extension.fetchStringPreference
import com.saehyun.data.network.user.SignInRequest
import com.saehyun.data.network.user.SignUpRequest
import com.saehyun.data.network.user.UserAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userAPI: UserAPI,
    private val tokenDataSource: TokenDataSource,
) : UserRepository {
    override suspend fun signIn(request: SignInRequest) {
        userAPI.signIn(request).content.apply {
            tokenDataSource.saveToken(accessToken, refreshToken)
        }
    }

    override suspend fun signUp(request: SignUpRequest) {
        userAPI.signUp(request).content.apply {
            tokenDataSource.saveToken(accessToken, refreshToken)
        }
    }

    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }
}