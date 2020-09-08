package com.mth.padc_podcast.views.viewholders

import android.view.View
import com.mth.padc_podcast.data.vos.CategoryVO
import com.mth.padc_podcast.delegate.CategoryDelegate
import com.mth.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_search.view.cardCategory
import kotlinx.android.synthetic.main.layout_item_category.view.*

class SearchPodcastViewHolder(itemView: View, private val delegate: CategoryDelegate) :
    BaseViewHolder<CategoryVO>(itemView) {

    init {
        itemView.cardCategory.setOnClickListener {
            mData?.let {
                delegate.onTapCategoryListItem()
            }
        }
    }

    override fun bindData(data: CategoryVO) {
        mData = data
        itemView.tvTitle.text = data.name
    }
}