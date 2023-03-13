package com.example.lastfmapi.api

import com.example.lastfmapi.dataclasses.GetTagInfo
import com.example.lastfmapi.dataclasses.GetTopTags
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmApi {

    companion object {
        const val URL = "https://ws.audioscrobbler.com"
    }

    @GET("/2.0")
    suspend fun getGenres(
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") api_key:String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetTopTags>

    @GET("/2.0")
    suspend fun getGenreInfo(
        @Query("method") method: String = "tag.getInfo",
        @Query("tag") tag: String,
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetTagInfo>

    @GET("2.0/")
    suspend fun getTagTopAlbums(
        @Query("method") method: String = "tag.gettopalbums",
        @Query("tag") tag: String,
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    )

}