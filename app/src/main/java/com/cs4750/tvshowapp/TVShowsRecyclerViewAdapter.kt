package com.cs4750.tvshowapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cs4750.tvshowapp.R.id


class TVShowsRecyclerViewAdapter(
    private val tvshows: List<TVShows>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<TVShowsRecyclerViewAdapter.TVViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tvshows, parent, false)
        return TVViewHolder(view)
    }


    inner class TVViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        var mItem: TVShows? = null
        val mTVImage: ImageView = mView.findViewById<View>(id.tv_image) as ImageView

    }


    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        val tv = tvshows[position]

        holder.mItem = tv


        Glide.with(holder.mView)
            .load( "https://image.tmdb.org/t/p/w500" + tv.tvImageUrl)
            .centerInside()
            .into(holder.mTVImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { tv ->
                mListener?.onItemClick(tv)
            }
        }

    }


    override fun getItemCount(): Int {
        return tvshows.size
    }
}