package com.example.lastfmapi.di

import com.example.lastfmapi.api.LastFmApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LastFmApiModule {
    @Singleton
    @Provides
    fun provideLastFmApi(
    ): LastFmApi = Retrofit.Builder()
        .baseUrl(LastFmApi.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(LastFmApi::class.java)
}