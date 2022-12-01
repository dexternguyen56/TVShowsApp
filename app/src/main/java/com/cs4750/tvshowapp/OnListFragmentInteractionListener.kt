package com.codepath.tvshowapp

/**
 * This interface is used by the [MoviesRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [BestSellerBooksFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: Movies)
}
