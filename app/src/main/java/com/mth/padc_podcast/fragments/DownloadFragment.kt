package com.mth.padc_podcast.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mth.padc_podcast.R
import com.mth.padc_podcast.adapters.DownloadPodcastAdapter
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.mvp.presenters.DownloadPodcastPresenter
import com.mth.padc_podcast.mvp.presenters.impls.DownloadPodcastPresenterImpl
import com.mth.padc_podcast.mvp.views.DownloadPodcastView
import kotlinx.android.synthetic.main.fragment_download.*

class DownloadFragment : Fragment(), DownloadPodcastView {
    private lateinit var mAdapter: DownloadPodcastAdapter
    private lateinit var mDownloadPodcastPresenter: DownloadPodcastPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_download, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mDownloadPodcastPresenter.onUIReady(this)
    }

    private fun setUpPresenter() {
        mDownloadPodcastPresenter =
            ViewModelProviders.of(this).get(DownloadPodcastPresenterImpl::class.java)
        mDownloadPodcastPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mAdapter = DownloadPodcastAdapter()
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_download.layoutManager = linearLayoutManager
        rv_download.adapter = mAdapter

    }

    override fun displayDownloadPodcastList(list: List<DownloadPodcastVO>) {
        mAdapter.setNewData(list.toMutableList())
    }
}