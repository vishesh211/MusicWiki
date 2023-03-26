package com.example.lastfmapi.di

import com.example.lastfmapi.api.LastFmApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LastFmApiModule {

    @Provides
    @Singleton
    fun provideLastFmApi(
        retrofit: Retrofit
    ): LastFmApi = retrofit.create(LastFmApi::class.java)
}