package com.codepath.tvshowapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var backDrop = intent.getStringExtra("backDrop")
        var tvTitle= intent.getStringExtra("name")
        var tvOverView= intent.getStringExtra("overview")
        var firstAir = intent.getStringExtra("airDate")

        val des = SpannableStringBuilder()
        val res = SpannableStringBuilder()
        val spanFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

        des.append("Description: ",StyleSpan(Typeface.BOLD), spanFlag)
        des.append(tvOverView)

        res.append("Released: ",StyleSpan(Typeface.BOLD), spanFlag)
        res.append(firstAir)

        val  tvBackdrop = findViewById<ImageView>(R.id.backdrop_imageView)
        val  tvName = findViewById<TextView>(R.id.title_textView)
        val  tvDescription = findViewById<TextView>(R.id.overview)
        val  firstAirTV = findViewById<TextView>(R.id.firstAir_textView)



        Glide.with(this)
            .load( "https://image.tmdb.org/t/p/w500" + backDrop )
            .fitCenter()
            .into(tvBackdrop)

        tvName.text = tvTitle
        tvDescription.text = des
        firstAirTV.text = res




//        val supportFragmentManager = supportFragmentManager
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.detail_content, DetailFragment(moviesID), null).commit()


    }
}