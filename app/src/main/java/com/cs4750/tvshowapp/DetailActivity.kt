package com.cs4750.tvshowapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var backDrop = intent.getStringExtra("backDrop")
        var tvTitle= intent.getStringExtra("name")
        var tvOverView= intent.getStringExtra("overview")
        var firstAir = intent.getStringExtra("airDate")
        var vote = intent.getStringExtra("voting")


        val des = SpannableStringBuilder()
        val res = SpannableStringBuilder()
        val voteSpan = SpannableStringBuilder()

        val spanFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

        des.append("Description: ",StyleSpan(Typeface.BOLD), spanFlag)
        des.append(tvOverView)

        res.append("Released: ",StyleSpan(Typeface.BOLD), spanFlag)
        res.append(firstAir)

        voteSpan.append("Rating: ",StyleSpan(Typeface.BOLD), spanFlag)
        voteSpan.append(vote)

        val  tvBackdrop = findViewById<ImageView>(R.id.backdrop_imageView)
        val  tvName = findViewById<TextView>(R.id.title_textView)
        val  tvDescription = findViewById<TextView>(R.id.overview)
        val  firstAirTV = findViewById<TextView>(R.id.firstAir_textView)
        val  tvRating = findViewById<TextView>(R.id.voting)


        Glide.with(this)
            .load( "https://image.tmdb.org/t/p/w500" + backDrop )
            .fitCenter()
            .into(tvBackdrop)

        tvName.text = tvTitle
//        tvName.setTextColor(Color.parseColor("#D24E08"))

        if(tvOverView.isNullOrBlank()){
            tvDescription.text = ""
        }
        else{
            tvDescription.text = des

        }

        firstAirTV.text = res

        tvRating.text = voteSpan

        // try block to hide Action bar
        try {
            this.supportActionBar!!.hide()
        } // catch block to handle NullPointerException
        catch (e: NullPointerException) {
        }


    }
}