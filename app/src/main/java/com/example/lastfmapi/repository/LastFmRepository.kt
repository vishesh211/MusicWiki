package com.example.lastfmapi.repository

import com.example.lastfmapi.api.LastFmInstance
import com.example.lastfmapi.dataclasses.GetTagInfo
import com.example.lastfmapi.dataclasses.GetTopAlbums
import com.example.lastfmapi.dataclasses.GetTopArtists
import com.example.lastfmapi.dataclasses.GetTopTags
import retrofit2.Response

class LastFmRepository {
    suspend fun getGenres(): Response<GetTopTags> {
        return LastFmInstance.lastFmApi.getGenres()
    }

    suspend fun getGenreInfo(tag: String): Response<GetTagInfo> {
        return LastFmInstance.lastFmApi.getGenreInfo(tag = tag)
    }

    suspend fun getTagTopAlbums(tag: String): Response<GetTopAlbums> {
        return LastFmInstance.lastFmApi.getTagTopAlbums(tag = tag)
    }

    suspend fun getTagTopArtists(tag: String): Response<GetTopArtists> {
        return LastFmInstance.lastFmApi.getTagTopArtists(tag = tag)
    }
}
