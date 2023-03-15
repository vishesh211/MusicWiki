package com.example.lastfmapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lastfmapi.adapters.AlbumsAdapter
import com.example.lastfmapi.adapters.ArtistsAdapter
import com.example.lastfmapi.adapters.TracksAdapter
import com.example.lastfmapi.databinding.ActivityGenreDetailBinding
import com.example.lastfmapi.dataclasses.Album
import com.example.lastfmapi.repository.LastFmRepository
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory
import com.google.android.material.tabs.TabLayout

class GenreDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenreDetailBinding
    private lateinit var viewModel: LastFmViewModel
    var albumList: MutableList<Album> = mutableListOf()
    var albumsAdapter: AlbumsAdapter = AlbumsAdapter(albumList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tag = intent.getStringExtra("tag")


        val lastFmRepository = LastFmRepository()
        val viewModelFactory = LastFmViewModelFactory(lastFmRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.getGenreInfo(tag.toString())
        viewModel.getTagTopAlbums(tag.toString())

        viewModel.tagTopAlbums.observe(this) {
            albumList.addAll(it.album)
            binding.detailRecyclerView.adapter = AlbumsAdapter(albumList)
        }
        binding.detailRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.detailRecyclerView.adapter = albumsAdapter

        viewModel.tagInfo.observe(this) {
            binding.tagTitle.text = it.name
            binding.tagInfo.text = it.wiki.summary
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.text!! == "ALBUMS"){
                    viewModel.getTagTopAlbums(tag.toString())
                    viewModel.tagTopAlbums.observe(this@GenreDetailActivity) {
                        albumList.addAll(it.album)
                        binding.detailRecyclerView.adapter = AlbumsAdapter(albumList)
                    }
                } else if (tab.text!! == "ARTISTS") {
                    viewModel.getTagTopArtists(tag.toString())
                    viewModel.tagTopArtists.observe(this@GenreDetailActivity) {
                        binding.detailRecyclerView.adapter = ArtistsAdapter(it.artist)
                    }
                } else if (tab.text!! == "TRACKS") {
                    viewModel.getTagTopTracks(tag.toString())
                    viewModel.tagTopTracks.observe(this@GenreDetailActivity) {
                        binding.detailRecyclerView.adapter = TracksAdapter(it.track)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}
