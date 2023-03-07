package com.example.lastfmapi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lastfmapi.repository.LastFmRepository

class LastFmViewModel(private val LastFmRepository: LastFmRepository): ViewModel() {

//    fun getTopTags() {
//        viewModelScope.launch {
//            val response = LastFmApi.getGenres().body()
//            if (response?.toptags?.tag?.isNotEmpty() == true){
//                response.toptags.tag.forEach {
//                    println(it.name)
//                }
//            } else{
//                Log.e("LastFmApi", "Api not working. List size zero!!!!!")
//            }
//        }
//    }
}