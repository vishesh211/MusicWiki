package com.example.lastfmapi.api

import com.example.lastfmapi.dataclasses.GetTopTags
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmApi {

    @GET("2.0/")
    suspend fun getGenres(
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") api_key:String,
        @Query("format") format: String = "json"
    ): Response<GetTopTags>
}