package com.mth.padc_podcast.views.viewholders

import android.view.View
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.padc_podcast.delegate.DownLoadedPodcastDelegate
import com.mth.padc_podcast.utils.load
import com.mth.shared.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_search.view.*
import kotlinx.android.synthetic.main.layout_item_podcast_download.view.*

class DownloadPodcastViewHolder(itemView: View) : BaseViewHolder<DownloadPodcastVO>(itemView) {

    override fun bindData(data: DownloadPodcastVO) {
        mData = data
        itemView.imv_song_cover.load(data.podcast.image)
        itemView.tv_podcast_title.text = data.podcast.title
    }
}