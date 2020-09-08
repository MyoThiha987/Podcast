package com.mth.padc_podcast.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc_podcast.R
import com.mth.padc_podcast.data.vos.CategoryVO
import com.mth.padc_podcast.delegate.CategoryDelegate
import com.mth.padc_podcast.views.viewholders.SearchPodcastViewHolder
import com.mth.shared.adapters.BaseRecyclerAdapter
import com.mth.shared.views.viewholders.BaseViewHolder

class SearchPodcastAdapter(private val delegate: CategoryDelegate) :
    BaseRecyclerAdapter<BaseViewHolder<CategoryVO>, CategoryVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CategoryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_category,parent,false)
        return SearchPodcastViewHolder(view,delegate)
    }
}