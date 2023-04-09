package com.example.lastfmapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.AlbumXX

class TopAlbumsArtistDetailAdapter(val list: List<AlbumXX>): RecyclerView.Adapter<TopAlbumsArtistDetailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val albumImage: ImageView = itemView.findViewById(R.id.albumImage)
        val albumTitle: TextView = itemView.findViewById(R.id.albumTitle)
        val albumArtistName: TextView = itemView.findViewById(R.id.albumArtistName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_albums_artist_detail, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val albumTitle = list[position].name
        val albumArtistName = list[position].artist.name
        holder.albumTitle.text = albumTitle
        holder.albumArtistName.text = albumArtistName
        Glide.with(holder.albumImage.context).load(list[position].image[0].text).into(holder.albumImage)
    }
}