package com.example.lastfmapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.databinding.ActivityMainBinding
import com.example.lastfmapi.repository.LastFmRepository
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LastFmViewModel
    private lateinit var binding: ActivityMainBinding
    private var isListExpanded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        createOrRefreshList()

        val lastFmRepository = LastFmRepository()
        val viewModelFactory = LastFmViewModelFactory(lastFmRepository)

        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.topTags.observe(this) {
            createOrRefreshList()
        }

    }

    private fun createOrRefreshList() {
        if (isListExpanded) {

        }
    }
}