package com.example.lastfmapi.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmapi.R
import com.example.lastfmapi.dataclasses.TagXX
import com.example.lastfmapi.ui.GenreDetailActivity

class AlbumInfoGenreAdapter(val list: List<TagXX>): RecyclerView.Adapter<AlbumInfoGenreAdapter.ViewHolder>() {
    class ViewHolder(itemVIew: View): RecyclerView.ViewHolder(itemVIew) {
        val genreName: TextView = itemView.findViewById(R.id.genreName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.genre_name, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genreName = list[position]
        holder.genreName.text = genreName.name
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, GenreDetailActivity::class.java)
            intent.putExtra("tag", genreName.name)
            it.context.startActivity(intent)
        }
    }
}
