package com.example.lastfmapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.Artist

class ArtistsAdapter(val list: List<Artist>): RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.artistImage)
        val textView: TextView = itemView.findViewById(R.id.artistName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artist_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = list[position]
        holder.textView.text = artist.name
        val i = artist.image.size
        Glide.with(holder.imageView).load(artist.image[i-1].text).into(holder.imageView)
    }
}