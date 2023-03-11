package com.example.lastfmapi.repository

import com.example.lastfmapi.api.LastFmInstance
import com.example.lastfmapi.dataclasses.GetTagInfo
import com.example.lastfmapi.dataclasses.GetTopTags
import retrofit2.Response

class LastFmRepository {
    suspend fun getGenres(): Response<GetTopTags> {
        return LastFmInstance.lastFmApi.getGenres()
    }

    suspend fun getGenreInfo(tag: String): Response<GetTagInfo> {
        return LastFmInstance.lastFmApi.getGenreInfo(tag = tag)
    }
}
