package com.cs4750.tvshowapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cs4750.tvshowapp.R.id

class TVShowsAdapter(
    private val tvShows: List<TVShows>,
    private val tvShowsListener: TVShowsListener?
    )
    : RecyclerView.Adapter<TVShowsAdapter.TVViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_tvshows, parent, false)
        return TVViewHolder(view)
    }
        
    inner class TVViewHolder(val tvView: View) : RecyclerView.ViewHolder(tvView) {
        var tvItem: TVShows? = null
        val tvImage: ImageView = tvView.findViewById<View>(id.tv_image) as ImageView

    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tv = tvShows[position]
        holder.tvItem = tv

        Glide.with(holder.tvView)
            .load( "https://image.tmdb.org/t/p/w500" + tv.tvImageUrl)
            .centerInside()
            .into(holder.tvImage)

        holder.tvView.setOnClickListener {
            holder.tvItem?.let { tv ->
                tvShowsListener?.onItemClick(tv)
            }
        }

    }

    override fun getItemCount(): Int {
        return tvShows.size
    }
}