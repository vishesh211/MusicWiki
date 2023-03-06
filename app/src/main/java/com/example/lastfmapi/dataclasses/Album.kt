package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("@attr")
    val attr: AttrXXXX,
    val artist: ArtistX,
    val image: List<ImageX>,
    val mbid: String,
    val name: String,
    val url: String
)