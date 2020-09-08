package com.mth.padc_podcast.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerControlView
import com.mth.padc_podcast.root.App.Companion.simpleExoplayer
import com.mth.padc_podcast.utils.ExoPlayerEventListener
import com.mth.padc_podcast.utils.buildMediaSource
import com.mth.padc_podcast.utils.load
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.layout_design_home_media_player.view.*

class ExoPlayerViewPod @JvmOverloads constructor(
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
        home_music_player.player = simpleExoplayer
    }

    fun releasePlayer() {
        if (simpleExoplayer != null) {
            playWhenReady = simpleExoplayer!!.playWhenReady
            playbackPosition = simpleExoplayer!!.currentPosition
            currentWindow = simpleExoplayer!!.currentWindowIndex
            simpleExoplayer?.removeListener(exoPlayerEventListener)
            simpleExoplayer?.release()
            simpleExoplayer = null
        }
    }

    fun setData(title: String, audioUrl: String, coverImageUrl: String) {
        tv_song_title.text = title
        imv_song_cover.load(coverImageUrl)
        val uri = Uri.parse(audioUrl)
        val mediaSource = buildMediaSource(context, uri)
        simpleExoplayer?.playWhenReady = playWhenReady
        simpleExoplayer?.seekTo(currentWindow, playbackPosition)
        simpleExoplayer?.addListener(exoPlayerEventListener)
        simpleExoplayer?.prepare(mediaSource, false, false)
    }
}