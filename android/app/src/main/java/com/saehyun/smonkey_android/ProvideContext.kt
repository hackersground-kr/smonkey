package com.saehyun.smonkey_android

import android.content.Context
import com.saehyun.data.network.user.UserAPI
import com.saehyun.data.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvideContext {

    @Singleton
    @Provides
    fun provideUserRepository(
        userAPI: UserAPI,
        @ApplicationContext context: Context,
    ): UserRepositoryImpl = UserRepositoryImpl(
        userAPI = userAPI,
        context = context,
    )
}