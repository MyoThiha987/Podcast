package com.mth.padc_podcast.views.viewholders

import android.view.View
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import com.mth.padc_podcast.delegate.UpNextPodcastsDelegate
import com.mth.padc_podcast.utils.load
import com.mth.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.layout_item_up_next.view.*

class UpNextPodcastViewHolder(itemView : View, private val delegate : UpNextPodcastsDelegate) : BaseViewHolder<UpNextPodcastVO>(itemView) {
    init {
        itemView.constraint.setOnClickListener {
            mData?.let {
                delegate.onTapUpNextPodcastItem(it.dataVO.podcast.pid)

            }
        }
        itemView.imvDownload.setOnClickListener {
            mData?.let {
                delegate.onTapDownloadListItem(it,downloadPodcastVO = DownloadPodcastVO())
            }
        }
    }

    override fun bindData(data: UpNextPodcastVO) {
        mData = data
        itemView.imv_song_cover.load(data.dataVO.podcast.image)
        itemView.tv_podcast_title.text = data.dataVO.podcast.title
    }

//    override fun onClickItem(data: UpNextPodcastVO) {
//        delegate.onTapUpNextPodcastItem(data.dataVO.podcast.pid)
//    }
}