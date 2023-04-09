package com.example.lastfmapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.TrackXX

class TopTracksAlbumDetailAdapter(val list: List<TrackXX>): RecyclerView.Adapter<TopTracksAlbumDetailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val trackImage: ImageView = itemView.findViewById(R.id.trackImage)
        val trackTitle: TextView = itemView.findViewById(R.id.trackTitle)
        val trackArtistName: TextView = itemView.findViewById(R.id.trackArtistName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_tracks_album_detail, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trackTitle = list[position].name
        val trackArtistName = list[position].artist.name
        holder.trackTitle.text = trackTitle
        holder.trackArtistName.text = trackArtistName
        Glide.with(holder.trackImage.context).load(list[position].image[0].text).into(holder.trackImage)
    }
}