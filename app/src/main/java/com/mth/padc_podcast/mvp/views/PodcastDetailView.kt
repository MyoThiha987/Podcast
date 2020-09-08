package com.mth.padc_podcast.mvp.views

import com.mth.padc_podcast.data.vos.PodcastDetailVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.shared.mvp.views.BaseView

interface PodcastDetailView : BaseView {
    fun displayDetailData(podcastDetailVO: PodcastDetailVO)
}