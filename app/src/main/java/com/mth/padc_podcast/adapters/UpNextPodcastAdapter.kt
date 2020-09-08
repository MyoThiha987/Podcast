package com.mth.padc_podcast.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_podcast.R
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.delegate.UpNextPodcastsDelegate
import com.mth.padc_podcast.views.viewholders.UpNextPodcastViewHolder
import com.mth.shared.adapters.BaseRecyclerAdapter
import com.mth.shared.views.viewholders.BaseViewHolder

class UpNextPodcastAdapter(private val delegate: UpNextPodcastsDelegate) : BaseRecyclerAdapter<BaseViewHolder<UpNextPodcastVO>, UpNextPodcastVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<UpNextPodcastVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_up_next,parent,false)
        return UpNextPodcastViewHolder(view,delegate)
    }

}