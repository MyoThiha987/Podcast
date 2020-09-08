package com.mth.padc_podcast.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import com.mth.padc_podcast.root.App
import com.mth.padc_podcast.utils.ExoPlayerEventListener
import com.mth.padc_podcast.utils.buildMediaSource
import kotlinx.android.synthetic.main.activity_podcast_detail.view.*


class MiniExoPlayerViewPod @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private val exoPlayerEventListener = ExoPlayerEventListener()

    override fun onFinishInflate() {
        super.onFinishInflate()
        initializePlayer()
    }

    private fun initializePlayer() {
        include.player = App.simpleExoplayer
    }

    fun releasePlayer() {
        if (App.simpleExoplayer != null) {
            playWhenReady = App.simpleExoplayer!!.playWhenReady
            playbackPosition = App.simpleExoplayer!!.currentPosition
            currentWindow = App.simpleExoplayer!!.currentWindowIndex
            App.simpleExoplayer?.removeListener(exoPlayerEventListener)
            App.simpleExoplayer?.release()
            App.simpleExoplayer = null
        }
    }

    fun setData(audioUrl: String) {
        val mediaSource = buildMediaSource(context, Uri.parse(audioUrl))
        //App.simpleExoplayer?.playWhenReady = playWhenReady
        //App.simpleExoplayer?.seekTo(currentWindow, playbackPosition)
        App.simpleExoplayer?.addListener(exoPlayerEventListener)
        App.simpleExoplayer?.prepare(mediaSource, false, false)
    }
}