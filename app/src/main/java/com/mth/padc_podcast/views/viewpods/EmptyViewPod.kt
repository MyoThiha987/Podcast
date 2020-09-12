package com.mth.padc_podcast.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.layout_empty_view.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: EmptyViewPodDelegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setDelegate(delegate: EmptyViewPodDelegate) {
        mDelegate = delegate
    }
}

interface EmptyViewPodDelegate {
    fun onTapTryAgain()
}