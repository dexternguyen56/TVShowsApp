package com.cs4750.tvshowapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONObject
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler


private const val API_KEY = "d9fc7af46dde39facb004b8ec757f86b"


class TVFragment : Fragment(), TVShowsListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tvshows_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list_tv) as RecyclerView
        val context = view.context
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        updateAdapter(progressBar, recyclerView)

        return view
    }


    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api_key"] = API_KEY

        client[
                "https://api.themoviedb.org/3/tv/popular",
                params,
                object : JsonHttpResponseHandler()
        {

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {

                progressBar.hide()

                val resultsJSON : JSONObject = json.jsonObject as JSONObject

                val tvJSON : String = resultsJSON.get("results").toString()

                val tvShowsType = object : TypeToken<List<TVShows>>() {}.type
                val models : List<TVShows> = Gson().fromJson(tvJSON, tvShowsType)
                recyclerView.adapter = TVShowsAdapter(models, this@TVFragment)

            }

            // On failure
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                t: Throwable?
            ) {
                progressBar.hide()
            }
        }]


    }


    override fun onItemClick(item: TVShows) {

       var i = Intent(context, DetailActivity::class.java )
        i.putExtra("name",item.title)
        i.putExtra("backDrop",item.backDropUrl)
        i.putExtra("overview",item.description )
        i.putExtra("airDate",item.firstAir)
        i.putExtra("voting",item.vote.toString())
        startActivity(i)
    }

}
