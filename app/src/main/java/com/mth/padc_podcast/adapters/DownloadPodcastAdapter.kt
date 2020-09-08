package com.mth.padc_podcast.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_podcast.R
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.PodcastVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.padc_podcast.delegate.*
import com.mth.padc_podcast.views.viewholders.DownloadPodcastViewHolder
import com.mth.padc_podcast.views.viewholders.SearchPodcastViewHolder
import com.mth.shared.adapters.BaseRecyclerAdapter
import com.mth.shared.views.viewholders.BaseViewHolder

class DownloadPodcastAdapter : BaseRecyclerAdapter<BaseViewHolder<DownloadPodcastVO>,DownloadPodcastVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DownloadPodcastVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_podcast_download,parent,false)
        return DownloadPodcastViewHolder(view)
    }

}