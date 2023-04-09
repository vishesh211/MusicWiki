package com.example.lastfmapi.repository

import com.example.lastfmapi.api.LastFmApi
import com.example.lastfmapi.dataclasses.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastFmRepository @Inject constructor(
    private val lastFmApi: LastFmApi
) {
    suspend fun getGenres(): Response<GetTopTags> {
        return lastFmApi.getGenres()
    }

    suspend fun getGenreInfo(tag: String): Response<GetTagInfo> {
        return lastFmApi.getGenreInfo(tag = tag)
    }

    suspend fun getTagTopAlbums(tag: String): Response<GetTopAlbums> {
        return lastFmApi.getTagTopAlbums(tag = tag)
    }

    suspend fun getTagTopArtists(tag: String): Response<GetTopArtists> {
        return lastFmApi.getTagTopArtists(tag = tag)
    }

    suspend fun getTagTopTracks(tag: String): Response<GetTopTracks> {
        return lastFmApi.getTagTopTracks(tag = tag)
    }

    suspend fun getAlbumInfo(artist: String, album: String): Response<GetAlbumInfo> {
        return lastFmApi.getAlbumInfo(artist = artist, album = album)
    }

    suspend fun getArtistInfo(artist: String): Response<GetArtistInfo> {
        return lastFmApi.getArtistInfo(artist = artist)
    }

    suspend fun getTopTracksForArtist(artist: String): Response<GetTopTracksForArtist> {
        return lastFmApi.getTopTracksForArtist(artist = artist)
    }

    suspend fun getTopAlbumsForArtist(artist: String): Response<GetTopAlbumsForArtist> {
        return lastFmApi.getTopAlbumsForArtist(artist = artist)
    }
}
