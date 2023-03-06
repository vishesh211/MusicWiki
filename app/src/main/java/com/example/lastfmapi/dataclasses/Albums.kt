package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("@attr")
    val attr: AttrXXX,
    val album: List<Album>
)