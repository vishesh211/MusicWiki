package com.example.lastfmapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.Album

class AlbumsAdapter(val list: List<Album>): RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.albumImage)
        val albumTitle: TextView = itemView.findViewById(R.id.albumTitle)
        val albumArtistName : TextView = itemView.findViewById(R.id.albumArtistName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.album_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = list[position]
        holder.albumTitle.text = album.name
        holder.albumArtistName.text = album.artist.name
        val i = album.image.size
        Glide.with(holder.imageView).load(album.image[i-1].text).into(holder.imageView)
    }
}
