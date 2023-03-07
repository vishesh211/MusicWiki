package com.example.lastfmapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.api.LastFmApi
import com.example.lastfmapi.repository.LastFmRepository

class LastFmViewModelFactory(private val LastFmRepository: LastFmRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LastFmViewModel(LastFmRepository) as T
    }
}