package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Toptracks(
    @SerializedName("@attr")
    val attr: AttrXXXXXXXX,
    val track: List<TrackXX>
)