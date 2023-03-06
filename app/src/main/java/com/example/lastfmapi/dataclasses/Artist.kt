package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("@attr")
    val attr: AttrXX,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)