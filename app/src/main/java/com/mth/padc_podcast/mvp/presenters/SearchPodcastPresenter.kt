package com.mth.padc_podcast.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.delegate.CategoryDelegate
import com.mth.padc_podcast.mvp.views.SearchPodcastView
import com.mth.shared.mvp.presenters.BasePresenter

interface SearchPodcastPresenter : BasePresenter<SearchPodcastView>,CategoryDelegate {
    fun onUIReady(lifecycleOwner: LifecycleOwner)

}