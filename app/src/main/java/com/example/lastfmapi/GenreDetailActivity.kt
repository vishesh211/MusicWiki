package com.example.lastfmapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.databinding.ActivityGenreDetailBinding
import com.example.lastfmapi.repository.LastFmRepository
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory

class GenreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenreDetailBinding
    private lateinit var viewModel: LastFmViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tag = intent.getStringExtra("tag")

        val lastFmRepository = LastFmRepository()
        val viewModelFactory = LastFmViewModelFactory(lastFmRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.getGenreInfo(tag.toString())

        viewModel.tagInfo.observe(this) {
            binding.tagTitle.text = it.name
            binding.tagInfo.text = it.wiki.summary
        }
    }
}
