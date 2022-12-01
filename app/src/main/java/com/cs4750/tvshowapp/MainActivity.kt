package com.cs4750.tvshowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cs4750.tvshowapp.R.id
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvShowsFragment: Fragment = TVFragment()
        val moviesFragment: Fragment = MoviesFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                id.nav_tv -> fragment = tvShowsFragment
                id.nav_movies -> fragment = moviesFragment
            }

            if (fragment == tvShowsFragment){
                setTitle("TV Shows")

            }
            else{
                setTitle("Movies")
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = id.nav_tv


    }

    private fun replaceFragment(newFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(id.frame_layout,newFragment)
        fragmentTransaction.commit()
    }

}