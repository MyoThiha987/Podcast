package com.mth.padc_podcast.mvp.views

import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.shared.mvp.views.BaseView

interface HomePodcastView : BaseView{
    fun displayUpNextPodcastList(list: List<UpNextPodcastVO>)
    fun displayRandomPodcast (data : RandomPodcastVO)
    fun navigateToDetailScreen(podcastId : String)
    fun downloadPodcastFromHome(upNextPodcastVO: UpNextPodcastVO,downloadPodcastVO: DownloadPodcastVO)
    fun onTouchPlayPause(audioUrl : String)

}