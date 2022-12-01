package com.cs4750.tvshowapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cs4750.tvshowapp.R.id


class MoviesRecyclerViewAdapter(
    private val movies: List<Movies>,
    private val mListener: OnListFragmentMoviesInteractionListener?
    )
    : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MoviesViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movies, parent, false)
        return MoviesViewHolder(view)
    }


    inner class MoviesViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        var mItem: Movies? = null
        val mTVImage: ImageView = mView.findViewById<View>(id.movies_image) as ImageView

    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val tv = movies[position]

        holder.mItem = tv


        Glide.with(holder.mView)
            .load( "https://image.tmdb.org/t/p/w500" + tv.moviesImageUrl)
            .centerInside()
            .into(holder.mTVImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { tv ->
                mListener?.onItemClick(tv)
            }
        }

    }


    override fun getItemCount(): Int {
        return movies.size
    }
}