package com.example.lastfmapi.api

import com.example.lastfmapi.dataclasses.*
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
    ): Response<GetTopAlbums>

    @GET("2.0/")
    suspend fun getTagTopArtists(
        @Query("method") method: String = "tag.gettopartists",
        @Query("tag") tag: String,
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetTopArtists>

    @GET("2.0/")
    suspend fun getTagTopTracks(
        @Query("method") method: String = "tag.gettoptracks",
        @Query("tag") tag: String,
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetTopTracks>

    @GET("2.0/")
    suspend fun getAlbumInfo(
        @Query("artist") artist: String,
        @Query("album") album: String,
        @Query("method") method: String = "album.getinfo",
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetAlbumInfo>

    @GET("2.0/")
    suspend fun getArtistInfo(
        @Query("artist") artist: String,
        @Query("method") method: String = "artist.getinfo",
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetArtistInfo>

    @GET("2.0/")
    suspend fun getTopTracksForArtist(
        @Query("artist") artist: String,
        @Query("method") method: String = "artist.gettoptracks",
        @Query("api_key") api_key: String = "3ec4da6005c36f71fdc94b95f46869d6",
        @Query("format") format: String = "json"
    ): Response<GetTopTracksForArtist>
}