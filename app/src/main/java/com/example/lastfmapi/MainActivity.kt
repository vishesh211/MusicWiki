package com.example.lastfmapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.api.LastFmInstance
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LastFmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastFmApi = LastFmInstance.lastFmApi
        val viewModelFactory = LastFmViewModelFactory(lastFmApi)

        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.getTopTags()

    }
}