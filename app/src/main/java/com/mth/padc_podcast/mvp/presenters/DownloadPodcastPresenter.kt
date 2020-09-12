package com.mth.padc_podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.delegate.DownLoadedPodcastDelegate
import com.mth.padc_podcast.mvp.views.DownloadPodcastView
import com.mth.padc_podcast.views.viewpods.EmptyViewPodDelegate
import com.mth.shared.mvp.presenters.BasePresenter

interface DownloadPodcastPresenter : BasePresenter<DownloadPodcastView>, DownLoadedPodcastDelegate{
    fun onUIReady(lifecycleOwner: LifecycleOwner)

}