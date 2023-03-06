package com.example.lastfmapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LastFmInstance {

    val lastFmApi: LastFmApi by lazy {
        Retrofit
            .Builder()
            .baseUrl(LastFmApi.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LastFmApi::class.java)
    }
}