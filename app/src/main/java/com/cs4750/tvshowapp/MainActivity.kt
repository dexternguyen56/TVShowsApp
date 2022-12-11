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

        // Fragments inits
        val tvShowsFragment: Fragment = TVFragment()
        val moviesFragment: Fragment = MoviesFragment()

        // bottom Navigation
        val bottomNavigation: BottomNavigationView = findViewById(id.bottom_navigation)

        // navigation fragment
        bottomNavigation.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                id.nav_tv -> fragment = tvShowsFragment
                id.nav_movies -> fragment = moviesFragment
            }

            if (fragment == tvShowsFragment){
                title = "TV Shows"

            }
            else{
                title = "Movies"
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigation.selectedItemId = id.nav_tv

    }

    // This function will replace a different fragment with FragmentManager
    private fun replaceFragment(newFragmentToReplace: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(id.frame_layout,newFragmentToReplace)
        transaction.commit()
    }

}