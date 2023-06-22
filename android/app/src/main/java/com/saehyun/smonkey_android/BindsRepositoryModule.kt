package com.saehyun.smonkey_android

import com.saehyun.data.repository.FeedRepository
import com.saehyun.data.repository.FeedRepositoryImpl
import com.saehyun.data.repository.JournalRepository
import com.saehyun.data.repository.JournalRepositoryImpl
import com.saehyun.data.repository.SmonkeyRepository
import com.saehyun.data.repository.SmonkeyRepositoryImpl
import com.saehyun.data.repository.TokenDataSource
import com.saehyun.data.repository.TokenDataSourceImpl
import com.saehyun.data.repository.UserRepository
import com.saehyun.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindsSMonkeyRepository(
        sMonkeyRepositoryImpl: SmonkeyRepositoryImpl
    ): SmonkeyRepository

    @Binds
    @Singleton
    abstract fun bindsFeedRepository(
        feedRepositoryImpl: FeedRepositoryImpl
    ): FeedRepository

    @Binds
    @Singleton
    abstract fun bindsJournalRepository(
        journalRepositoryImpl: JournalRepositoryImpl
    ): JournalRepository

    @Binds
    @Singleton
    abstract fun bindsTokenDataSourceImpl(
        tokenDataSourceImpl: TokenDataSourceImpl
    ): TokenDataSource
}
