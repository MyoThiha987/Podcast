package com.mth.padc_podcast.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc_podcast.data.models.PodcastsModel
import com.mth.padc_podcast.data.models.impl.PodcastsModelImpl
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.mvp.presenters.AbstractBasePresenter
import com.mth.padc_podcast.mvp.presenters.HomePodcastPresenter
import com.mth.padc_podcast.mvp.views.HomePodcastView

class HomePodcastPresenterImpl : HomePodcastPresenter, AbstractBasePresenter<HomePodcastView>() {

    var mModelImpl: PodcastsModel = PodcastsModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        fetchRandomPodcastToDb()
        loadRandomPodcastFromDb(lifecycleOwner)
        fetchUpNextPodcastToDb()
        loadUpNextPodcastListFromDb(lifecycleOwner)

    }

    override fun onDownloadPodcast(
        context: Context,
        upNextPodcastVO: UpNextPodcastVO,
        downloadPodcastVO: DownloadPodcastVO
    ) {
        mModelImpl.startDownloadPodcast(context, upNextPodcastVO, downloadPodcastVO)
    }

    private fun fetchRandomPodcastToDb() {
        mModelImpl.getRandomPodCastFromApiAndSaveToDatabase({}, {})
    }

    private fun loadRandomPodcastFromDb(lifecycleOwner: LifecycleOwner) {
        mModelImpl.getRandomPodCast(onError = {})
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayRandomPodcast(it)
                }
            })
    }

    private fun fetchUpNextPodcastToDb() {
        mModelImpl.getUpNextPodCastListFromApiAndSaveToDatabase({}, {})
    }

    private fun loadUpNextPodcastListFromDb(lifecycleOwner: LifecycleOwner) {
        mModelImpl.getUpNextPodCast(onError = {})
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayUpNextPodcastList(it)
                }
            })
    }

    override fun onTapUpNextPodcastItem(podcastId: String) {
        mView?.navigateToDetailScreen(podcastId)

    }

    override fun onTapDownloadListItem(upNextPodcastVO: UpNextPodcastVO,downloadPodcastVO: DownloadPodcastVO) {
        mView?.downloadPodcastFromHome(upNextPodcastVO,downloadPodcastVO)
    }
}