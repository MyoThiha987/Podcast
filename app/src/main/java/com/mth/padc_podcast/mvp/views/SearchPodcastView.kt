package com.mth.padc_podcast.mvp.views

import com.mth.padc_podcast.data.vos.CategoryVO
import com.mth.shared.mvp.views.BaseView

interface SearchPodcastView : BaseView {
    fun displayGenreList(list: List<CategoryVO>)
    fun navigateToDetailScreen()
}