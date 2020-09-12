package com.mth.padc_podcast.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc_podcast.data.models.PodcastsModel
import com.mth.padc_podcast.data.models.impl.PodcastsModelImpl
import com.mth.padc_podcast.mvp.presenters.AbstractBasePresenter
import com.mth.padc_podcast.mvp.presenters.DownloadPodcastPresenter
import com.mth.padc_podcast.mvp.views.DownloadPodcastView

class DownloadPodcastPresenterImpl : DownloadPodcastPresenter,AbstractBasePresenter<DownloadPodcastView>() {
    var mModel : PodcastsModel = PodcastsModelImpl
    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        loadDownloadPodcastFromDb(lifecycleOwner)
    }

    override fun onTapDownloadedItem(podcastId: String) {
        mView?.navigateToDetailScreen(podcastId)
    }

    private fun loadDownloadPodcastFromDb(lifecycleOwner: LifecycleOwner){
        mModel.getAllDownloadPodcastList().observe(lifecycleOwner, Observer {
            it.let {
                mView?.displayDownloadPodcastList(it)
            }
        })
    }


}