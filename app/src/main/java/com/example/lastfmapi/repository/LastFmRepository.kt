package com.example.lastfmapi.repository

import com.example.lastfmapi.api.LastFmApi
import com.example.lastfmapi.api.LastFmInstance
import com.example.lastfmapi.dataclasses.GetTopTags
import retrofit2.Response

class LastFmRepository {
    suspend fun getGenres(): Response<GetTopTags> {
        return LastFmInstance.lastFmApi.getGenres()
    }
}