package com.mth.padc_podcast.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mth.padc_podcast.R
import com.mth.padc_podcast.fragments.DownloadFragment
import com.mth.padc_podcast.fragments.HomeFragment
import com.mth.padc_podcast.fragments.ProfileFragment
import com.mth.padc_podcast.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val downloadFragment = DownloadFragment()
    private val profileFragment = ProfileFragment()
    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //changeFragment(HomeFragment())
        setUpFragmentManager()
        changeFragments(homeFragment)
        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {

        bottomNav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.home -> {
                    // changeFragment(HomeFragment())
                    changeFragments(homeFragment)
                }

                R.id.search -> {
                    //changeFragment(SearchFragment())
                    changeFragments(searchFragment)
                }

                R.id.download -> {
                    // changeFragment(DownloadFragment())
                    changeFragments(downloadFragment)
                }

                R.id.profile -> {
                    //changeFragment(ProfileFragment())
                    changeFragments(profileFragment)

                }
            }
            true
        }
    }

    private fun setUpFragmentManager() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, searchFragment).hide(searchFragment)
            add(R.id.container, downloadFragment).hide(downloadFragment)
            add(R.id.container, profileFragment).hide(profileFragment)
            add(R.id.container, homeFragment)
        }.commit()
    }

    private fun changeFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment).commit()
        activeFragment = fragment
    }





}