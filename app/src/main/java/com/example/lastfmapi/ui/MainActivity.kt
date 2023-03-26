package com.example.lastfmapi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.lastfmapi.R
import com.example.lastfmapi.databinding.ActivityMainBinding
import com.example.lastfmapi.dataclasses.TagX
import com.example.lastfmapi.repository.LastFmRepository
import com.example.lastfmapi.viewmodel.LastFmViewModel
import com.example.lastfmapi.viewmodel.LastFmViewModelFactory
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LastFmViewModel
    private lateinit var binding: ActivityMainBinding
    private var list: List<TagX> = emptyList()
    private var isListExpanded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createOrRefreshList()

        val lastFmRepository = LastFmRepository()
        val viewModelFactory = LastFmViewModelFactory(lastFmRepository)

        viewModel = ViewModelProvider(this, viewModelFactory)[LastFmViewModel::class.java]

        viewModel.getTopTags()
        viewModel.topTags.observe(this) {
            list = it
            createOrRefreshList(list)
        }
        binding.toggleLayout.setOnClickListener {
            onToggleLayoutClicked()
        }
    }

    private fun createOrRefreshList(tagList: List<TagX> = emptyList()) {
        if (isListExpanded) {
            binding.toggleIcon.setImageResource(R.drawable.list_drop_down_close)
        } else {
            binding.toggleIcon.setImageResource(R.drawable.list_drop_down_open)
        }
        binding.chipGroup.removeAllViews()

        for (i in 1 until tagList.size) {
            if (i == 10 && !isListExpanded) {
                break
            }

            val chip = Chip(this)
            chip.text = tagList[i].name
            chip.setChipBackgroundColorResource(R.color.purple_700)

            chip.setOnClickListener {
                val intent = Intent(this, GenreDetailActivity::class.java)
                intent.putExtra("tag", tagList[i].name)
                startActivity(intent)
            }

            binding.chipGroup.addView(chip)
        }
    }

    private fun onToggleLayoutClicked() {
        isListExpanded = !isListExpanded
        createOrRefreshList(list)
    }
}
