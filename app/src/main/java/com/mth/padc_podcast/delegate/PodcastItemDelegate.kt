package com.mth.padc_podcast.delegate

import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO


interface CategoryDelegate {
    fun onTapCategoryListItem()
}

interface UpNextPodcastsDelegate {
    fun onTapUpNextPodcastItem(podcastId :String)
    fun onTapDownloadListItem(upNextPodcastVO: UpNextPodcastVO,downloadPodcastVO: DownloadPodcastVO)
}

interface DownLoadedPodcastDelegate{
    fun onTapDownloadedItem()
}
