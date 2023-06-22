package com.saehyun.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.saehyun.data.local.datastore
import com.saehyun.data.local.extension.fetchStringPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TokenDataSourceImpl @Inject constructor(
    private val context: Context,
) : TokenDataSource {
    override suspend fun getToken(): Flow<String> =
        context.fetchStringPreference(UserRepositoryImpl.ACCESS_TOKEN)

    override suspend fun saveToken(
        accessToken: String,
        refreshToken: String,
    ) {
        context.datastore.edit { preference ->
            preference[UserRepositoryImpl.ACCESS_TOKEN] = accessToken
            preference[UserRepositoryImpl.REFRESH_TOKEN] = refreshToken
        }
    }
}