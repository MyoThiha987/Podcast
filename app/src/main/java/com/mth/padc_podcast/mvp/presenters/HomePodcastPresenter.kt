package com.mth.padc_podcast.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.delegate.UpNextPodcastsDelegate
import com.mth.padc_podcast.mvp.views.HomePodcastView
import com.mth.padc_podcast.views.viewpods.HomePlayerViewPod
import com.mth.shared.mvp.presenters.BasePresenter

interface HomePodcastPresenter : BasePresenter<HomePodcastView>,UpNextPodcastsDelegate {
    fun onUIReady(lifecycleOwner: LifecycleOwner)
    fun onDownloadPodcast(context : Context,upNextPodcastVO: UpNextPodcastVO,downloadPodcastVO: DownloadPodcastVO)

}