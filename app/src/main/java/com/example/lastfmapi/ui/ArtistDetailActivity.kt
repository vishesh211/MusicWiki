package com.example.lastfmapi.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.lastfmapi.adapters.AlbumInfoGenreAdapter
import com.example.lastfmapi.adapters.TopAlbumsArtistDetailAdapter
import com.example.lastfmapi.adapters.TopTracksArtistDetailAdapter
import com.example.lastfmapi.databinding.ActivityArtistDetailBinding
import com.example.lastfmapi.dataclasses.AlbumXX
import com.example.lastfmapi.dataclasses.TagXX
import com.example.lastfmapi.dataclasses.TrackXX
import com.example.lastfmapi.viewmodel.LastFmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistDetailActivity : AppCompatActivity() {

    private val viewModel: LastFmViewModel by viewModels()

    private lateinit var binding: ActivityArtistDetailBinding

    var genreNameList: MutableList<TagXX> = mutableListOf()
    private val albumGenreInfoAdapter: AlbumInfoGenreAdapter = AlbumInfoGenreAdapter(genreNameList)

    val trackList: MutableList<TrackXX> = mutableListOf()
    private val topTracksArtistDetailAdapter: TopTracksArtistDetailAdapter = TopTracksArtistDetailAdapter(trackList)

    val albumList: MutableList<AlbumXX> = mutableListOf()
    private val topAlbumsArtistDetailAdapter: TopAlbumsArtistDetailAdapter = TopAlbumsArtistDetailAdapter(albumList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val artist = intent.getStringExtra("artist")

        viewModel.getArtistInfo(artist.toString())
        viewModel.getTopTracksForArtist(artist.toString())
        viewModel.getTopAlbumsForArtist(artist.toString())

        viewModel.artistInfo.observe(this) {
            Glide.with(this).load(it.image[1].text).into(binding.artistInfoImage)
            binding.artistInfoPlayCountNumber.text = it.stats.playcount
            binding.artistInfoFollowerNumber.text = it.stats.listeners
            genreNameList.addAll(it.tags.tag)
            binding.artistInfoRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.artistInfoRv.adapter = albumGenreInfoAdapter
        }

        viewModel.toptracks.observe(this) {
            trackList.addAll(it.track)
            binding.topTracksArtistRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
            binding.topTracksArtistRv.adapter = topTracksArtistDetailAdapter
        }

        viewModel.topAlbums.observe(this) {
            albumList.addAll(it.album)
            binding.topAlbumsArtistRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.topAlbumsArtistRv.adapter = topAlbumsArtistDetailAdapter
        }
    }
}