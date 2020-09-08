package com.mth.padc_podcast.mvp.presenters.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LifecycleOwner
import com.mth.padc_podcast.data.models.PodcastsModel
import com.mth.padc_podcast.data.models.impl.PodcastsModelImpl
import com.mth.padc_podcast.mvp.presenters.AbstractBasePresenter
import com.mth.padc_podcast.mvp.presenters.PodcastDetailPresenter
import com.mth.padc_podcast.mvp.views.PodcastDetailView

class PodcastDetailPresenterImpl : PodcastDetailPresenter,
    AbstractBasePresenter<PodcastDetailView>() {
    var mModelImpl: PodcastsModel = PodcastsModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String) {
        fetchPodcastDetailById(episodeID)
    }

    @SuppressLint("CheckResult")
    private fun fetchPodcastDetailById(episodeID: String) {
        mModelImpl.getDetailPodcast(episodeID, {})
            .subscribe {
                it.let {
                    mView?.displayDetailData(it)
                }
            }
    }
}