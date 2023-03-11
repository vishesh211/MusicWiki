package com.example.lastfmapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.repository.LastFmRepository
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LastFmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastFmRepository = LastFmRepository()
        val viewModelFactory = LastFmViewModelFactory(lastFmRepository)

        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.topTags.observe(this) {
            
        }

    }
}