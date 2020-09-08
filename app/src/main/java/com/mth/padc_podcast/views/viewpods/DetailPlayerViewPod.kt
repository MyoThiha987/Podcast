package com.mth.padc_podcast.views.viewpods

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.podcast_detail_exo_player_viewpod.view.*


class DetailPlayerViewPod @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {


    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setData(position:Int,duration:Int){
        tv_position.text = duration.toString()
        tv_duration.text = duration.toString()

    }
}