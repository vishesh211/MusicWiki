package com.example.lastfmapi.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lastfmapi.databinding.ActivityAlbumDetailBinding
import com.example.lastfmapi.viewmodel.LastFmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailActivity : AppCompatActivity() {

    private val viewModel: LastFmViewModel by viewModels()

    private lateinit var binding: ActivityAlbumDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val albumName = intent.getStringExtra("album name")
        val artistName = intent.getStringExtra("artist name")
        viewModel.getAlbumInfo(album = albumName.toString(), artist = artistName.toString())

        binding.albumInfoName.text = albumName.toString()
        binding.albumArtistInfoName.text = artistName.toString()

        viewModel.albumInfo.observe(this) {
            Glide.with(this).load(it.image[0].text).into(binding.albumImage)
            binding.albumInfoAlbumDetail.text = it.wiki.summary
        }
    }
}