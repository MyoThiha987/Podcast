package com.mth.padc_podcast.mvp.views

import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.shared.mvp.views.BaseView

interface DownloadPodcastView : BaseView {
    fun displayDownloadPodcastList(list: List<DownloadPodcastVO>)
}