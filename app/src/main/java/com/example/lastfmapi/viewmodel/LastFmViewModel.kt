package com.example.lastfmapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapi.dataclasses.TagX
import com.example.lastfmapi.repository.LastFmRepository
import kotlinx.coroutines.launch

class LastFmViewModel(private val LastFmRepository: LastFmRepository): ViewModel() {

    private val _topTags: MutableLiveData<List<TagX>> = MutableLiveData()
    val topTags: LiveData<List<TagX>> = _topTags
    private fun getTopTags() {
        viewModelScope.launch {
            val response = LastFmRepository.getGenres()
            if (response.isSuccessful){
                _topTags.value = response.body()?.toptags?.tag
            }
        }
    }
}