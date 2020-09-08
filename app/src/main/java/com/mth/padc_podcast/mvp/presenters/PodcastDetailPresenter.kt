package com.mth.padc_podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.mvp.views.PodcastDetailView
import com.mth.shared.mvp.presenters.BasePresenter

interface PodcastDetailPresenter : BasePresenter<PodcastDetailView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, podcastId: String)
}