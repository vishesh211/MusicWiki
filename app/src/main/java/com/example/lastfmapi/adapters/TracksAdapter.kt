package com.example.lastfmapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.Track

class TracksAdapter(val list: List<Track>): RecyclerView.Adapter<TracksAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.trackImage)
        val trackTile: TextView = itemView.findViewById(R.id.trackTitle)
        val trackArtist:  TextView = itemView.findViewById(R.id.trackArtistName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.track_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = list[position]
        holder.trackTile.text = track.name
        holder.trackArtist.text = track.artist.name
        val i = track.image.size
        println(track.image.size)
        Glide.with(holder.imageView).load(track.image[i-1].text).into(holder.imageView)
    }
}