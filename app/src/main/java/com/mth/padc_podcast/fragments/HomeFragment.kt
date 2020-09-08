package com.mth.padc_podcast.fragments

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.mth.padc_podcast.R
import com.mth.padc_podcast.activities.PodcastDetailActivity
import com.mth.padc_podcast.adapters.UpNextPodcastAdapter
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.mvp.presenters.HomePodcastPresenter
import com.mth.padc_podcast.mvp.presenters.impls.HomePodcastPresenterImpl
import com.mth.padc_podcast.mvp.views.HomePodcastView
import com.mth.padc_podcast.root.App
import com.mth.padc_podcast.utils.load
import com.mth.padc_podcast.views.viewpods.ExoPlayerViewPod
import com.mth.shared.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_design_home_media_player.*
import kotlinx.android.synthetic.main.layout_podcast_description.*


class HomeFragment : BaseFragment(), HomePodcastView, Player.EventListener {
    private lateinit var mHomePresenter: HomePodcastPresenter
    private lateinit var mAdapter: UpNextPodcastAdapter
    private var permissionGranted: Boolean? = false
    private lateinit var mExoplayerViewPod: ExoPlayerViewPod

    companion object {
        private const val REQUEST_CODE = 1000
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        setUpExoPlayerViewPod()
        checkPermissionOnInit()
        mHomePresenter.onUIReady(this)

    }

    private fun setUpPresenter() {
        mHomePresenter = ViewModelProviders.of(this).get(HomePodcastPresenterImpl::class.java)
        mHomePresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mAdapter = UpNextPodcastAdapter(mHomePresenter)
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_up_next.layoutManager = linearLayoutManager
        rv_up_next.adapter = mAdapter
    }

    override fun displayUpNextPodcastList(list: List<UpNextPodcastVO>) {
        mAdapter.setNewData(list.toMutableList())
    }

    override fun displayRandomPodcast(data: RandomPodcastVO) {
        bindUI(data)
        mExoplayerViewPod.setData(data.podcast.title, data.link, data.podcast.image)

    }

    override fun navigateToDetailScreen(podcastId: String) {
        startActivity(PodcastDetailActivity.newIntent(requireContext(), podcastId))
    }

    override fun downloadPodcastFromHome(
        upNextPodcastVO: UpNextPodcastVO,
        downloadPodcastVO: DownloadPodcastVO
    ) {
        setupPermissions(upNextPodcastVO, downloadPodcastVO)

    }

    override fun onTouchPlayPause(audioUrl: String) {
        TODO("Not yet implemented")
    }

    private fun bindUI(data: RandomPodcastVO) {
        imv_song_cover.load(data.podcast.image)
        tv_song_title.text = data.podcast.title
        tv_song_title_hash.text = data.podcast.publisher
        tvDesc.text = Html.fromHtml(data.description)

    }

    private fun setUpExoPlayerViewPod() {
        mExoplayerViewPod = home_music_player as ExoPlayerViewPod

    }

    private fun checkPermissionOnInit() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            permissionGranted = true
        }
    }

    fun setupPermissions(upNextPodcastVO: UpNextPodcastVO, downloadPodcastVO: DownloadPodcastVO) {
        val permission = ContextCompat.checkSelfPermission(
            activity as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        } else {
            upNextPodcastVO.let {
                mHomePresenter.onDownloadPodcast(
                    activity as Context,
                    it,
                    downloadPodcastVO
                )
            }
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            activity as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(activity as Activity, "Permission Denied", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(context, "Permission Granted", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        App.simpleExoplayer?.release()
    }


}