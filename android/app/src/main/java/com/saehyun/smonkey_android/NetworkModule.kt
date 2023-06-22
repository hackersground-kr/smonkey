package com.saehyun.smonkey_android

import com.saehyun.data.network.smonkey.SMonkeyAPI
import com.saehyun.data.network.user.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://smonkey.azurewebsites.net:443"

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        synchronized(this) {
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        synchronized(this) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    @Provides
    @Singleton
    fun provideUserAPI(retrofit: Retrofit): UserAPI = synchronized(this) {
        retrofit.create(UserAPI::class.java)
    }

    @Provides
    @Singleton
    fun smonkeyAPI(retrofit: Retrofit): SMonkeyAPI = synchronized(this) {
        retrofit.create(SMonkeyAPI::class.java)
    }
}
