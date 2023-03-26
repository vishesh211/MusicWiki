package com.example.lastfmapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapi.dataclasses.*
import com.example.lastfmapi.repository.LastFmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFmViewModel @Inject constructor(private val LastFmRepository: LastFmRepository): ViewModel() {

    private val _topTags: MutableLiveData<List<TagX>> = MutableLiveData()
    val topTags: LiveData<List<TagX>> = _topTags

    private val _tagInfo: MutableLiveData<Tag> = MutableLiveData()
    val tagInfo: LiveData<Tag> = _tagInfo

    private val _tagTopAlbums: MutableLiveData<Albums> = MutableLiveData()
    val tagTopAlbums: LiveData<Albums> = _tagTopAlbums

    private val _tagTopArtists: MutableLiveData<Topartists> = MutableLiveData()
    val tagTopArtists: LiveData<Topartists> = _tagTopArtists

    private val _tagTopTracks: MutableLiveData<Tracks> = MutableLiveData()
    val tagTopTracks: LiveData<Tracks> = _tagTopTracks
    fun getTopTags() {
        viewModelScope.launch {
            val response = LastFmRepository.getGenres()
            if (response.isSuccessful){
                _topTags.value = response.body()?.toptags?.tag
            }
        }
    }

    fun getGenreInfo(tag: String) {
        viewModelScope.launch {
            val response = LastFmRepository.getGenreInfo(tag)
            if (response.isSuccessful) {
                _tagInfo.value = response.body()?.tag
            }
        }
    }

    fun getTagTopAlbums(tag: String) {
        viewModelScope.launch {
            val response = LastFmRepository.getTagTopAlbums(tag)
            if (response.isSuccessful) {
                _tagTopAlbums.value = response.body()?.albums
            }
        }
    }

    fun getTagTopArtists(tag: String) {
        viewModelScope.launch {
            val response = LastFmRepository.getTagTopArtists(tag)
            if (response.isSuccessful) {
                _tagTopArtists.value = response.body()?.topartists
            }
        }
    }

    fun getTagTopTracks(tag: String) {
        viewModelScope.launch {
            val response = LastFmRepository.getTagTopTracks(tag)
            if (response.isSuccessful) {
                _tagTopTracks.value = response.body()?.tracks
            }
        }
    }
}
