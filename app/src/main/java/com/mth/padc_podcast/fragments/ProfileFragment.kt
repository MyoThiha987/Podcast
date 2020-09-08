package com.mth.padc_podcast.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.mth.padc_podcast.R
import com.mth.padc_podcast.mvp.presenters.ProfilePresenter
import com.mth.padc_podcast.mvp.presenters.impls.HomePodcastPresenterImpl
import com.mth.padc_podcast.mvp.presenters.impls.ProfilePresenterImpl
import com.mth.padc_podcast.mvp.views.ProfileView

class ProfileFragment : Fragment(),ProfileView {
    private lateinit var mProfilePresenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        //mProfilePresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mProfilePresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mProfilePresenter.initPresenter(this)
    }
}