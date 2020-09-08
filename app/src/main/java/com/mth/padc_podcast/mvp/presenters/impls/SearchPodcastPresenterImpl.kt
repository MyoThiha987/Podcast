package com.mth.padc_podcast.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mth.padc_podcast.data.models.PodcastsModel
import com.mth.padc_podcast.data.models.impl.PodcastsModelImpl
import com.mth.padc_podcast.mvp.presenters.AbstractBasePresenter
import com.mth.padc_podcast.mvp.presenters.SearchPodcastPresenter
import com.mth.padc_podcast.mvp.views.SearchPodcastView

class SearchPodcastPresenterImpl : SearchPodcastPresenter,
    AbstractBasePresenter<SearchPodcastView>() {
    var mModelImpl: PodcastsModel = PodcastsModelImpl
    override fun onUIReady(lifecycleOwner: LifecycleOwner) {
        fetchGenreToDb()
        loadCategoryListFromDb(lifecycleOwner)

    }

    private fun fetchGenreToDb() {
        mModelImpl.getCategoryFromApiAndSaveToDatabase({}, {})
    }

    private fun loadCategoryListFromDb(lifecycleOwner: LifecycleOwner) {
        mModelImpl.getGenreList({})
            .observe(lifecycleOwner, Observer {
                it.let {
                    mView?.displayGenreList(it)
                }
            })
    }

    override fun onTapCategoryListItem() {
        mView?.navigateToDetailScreen()
    }
}