package com.cs4750.tvshowapp

import com.google.gson.annotations.SerializedName


class Movies {

    @SerializedName("poster_path")
    var moviesImageUrl: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("backdrop_path")
    var backDropUrl: String? = null

    @SerializedName("release_date")
    var firstAir: String? = null

    @SerializedName("vote_average")
    var vote: Float? = null

    @JvmField
    @SerializedName("original_title")
    var title: String? = null

}