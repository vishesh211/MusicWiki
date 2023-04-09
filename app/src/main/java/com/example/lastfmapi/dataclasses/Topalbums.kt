package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Topalbums(
    @SerializedName("@attr")
    val attr: AttrXXXXXXXXXX,
    val album: List<AlbumXX>
)