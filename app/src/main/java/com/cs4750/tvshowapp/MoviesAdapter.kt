package com.cs4750.tvshowapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cs4750.tvshowapp.R.id


class MoviesAdapter(
    private val movies: List<Movies>,
    private val movieListener: MoviesListener?
    )
    : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movies, parent, false)
        return MoviesViewHolder(view)
    }
        
    inner class MoviesViewHolder(val movieView: View) : RecyclerView.ViewHolder(movieView) {
        var movieItem: Movies? = null
        val movieImage: ImageView = movieView.findViewById<View>(id.movies_image) as ImageView

    }
        
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]

        holder.movieItem = movie

        Glide.with(holder.movieView)
            .load( "https://image.tmdb.org/t/p/w500" + movie.moviesImageUrl)
            .centerInside()
            .into(holder.movieImage)

        holder.movieView.setOnClickListener {
            holder.movieItem?.let { tv ->
                movieListener?.onItemClick(tv)
            }
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}