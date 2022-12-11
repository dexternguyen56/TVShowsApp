package com.cs4750.tvshowapp

import com.google.gson.annotations.SerializedName

class TVShows {

    @SerializedName("poster_path")
    var tvImageUrl: String? = null

    @SerializedName("backdrop_path")
    var backDropUrl: String? = null

    @SerializedName("first_air_date")
    var firstAir: String? = null

    @SerializedName("vote_average")
    var vote: Float? = null

    @SerializedName("overview")
    var description: String? = null

    @JvmField
    @SerializedName("original_name")
    var title: String? = null


}