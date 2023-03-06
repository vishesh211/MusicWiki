package com.example.lastfmapi.dataclasses

import com.google.gson.annotations.SerializedName

data class Topartists(
    @SerializedName("@attr")
    val attr: AttrX,
    val artist: List<Artist>
)