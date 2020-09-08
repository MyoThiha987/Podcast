package com.mth.padc_podcast.views.viewpods

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import com.mth.padc_podcast.utils.load
import kotlinx.android.synthetic.main.home_exo_player_viewpod.view.*

class HomePlayerViewPod @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {


    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(title:String,duration:Int,url:String){
        tv_song_title.text = title
        imv_song_cover.load(url)
        tv_duration.text = duration.toString()
    }
}