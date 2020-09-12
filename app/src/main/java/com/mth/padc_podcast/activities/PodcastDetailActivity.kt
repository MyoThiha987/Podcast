package com.mth.padc_podcast.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.ViewModelProviders
import com.google.android.exoplayer2.Player
import com.mth.padc_podcast.R
import com.mth.padc_podcast.data.vos.PodcastDetailVO
import com.mth.padc_podcast.mvp.presenters.PodcastDetailPresenter
import com.mth.padc_podcast.mvp.presenters.impls.PodcastDetailPresenterImpl
import com.mth.padc_podcast.mvp.views.PodcastDetailView
import com.mth.padc_podcast.utils.load
import com.mth.padc_podcast.views.viewpods.MiniExoPlayerViewPod
import com.mth.shared.mvp.views.BaseView
import kotlinx.android.synthetic.main.activity_podcast_detail.*
import kotlinx.android.synthetic.main.activity_podcast_detail.imv_song_cover

class PodcastDetailActivity : AppCompatActivity(),PodcastDetailView,Player.EventListener,BaseView {

    private lateinit var mPresenter: PodcastDetailPresenter
    private lateinit var mExoplayerViewPod : MiniExoPlayerViewPod

    companion object {
        const val PODCAST_ID_EXTRA = "Movie Id Extra"
        fun newIntent(context: Context,podcastId : String): Intent {
            val intent = Intent(context, PodcastDetailActivity::class.java)
            intent.putExtra(PODCAST_ID_EXTRA,podcastId)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast_detail)
        setUpPresenter()
        setUpExoPlayerViewPod()
        intent.getStringExtra(PODCAST_ID_EXTRA)?.let { mPresenter.onUiReady(this, it) }

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(PodcastDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDetailData(podcastDetailVO: PodcastDetailVO) {
       bindUI(podcastDetailVO)
    }

    private fun setUpExoPlayerViewPod(){
        mExoplayerViewPod = include as MiniExoPlayerViewPod
    }

    private fun bindUI(podcastDetailVO: PodcastDetailVO){
        imv_song_cover.load(podcastDetailVO.image)
        tv_podcast_title.text = podcastDetailVO.podcast.title
        tv_podcast_body.text = Html.fromHtml(podcastDetailVO.description)
        mExoplayerViewPod.setData(podcastDetailVO.audio)
    }

    /*override fun onResume() {
        super.onResume()
        App.simpleExoplayer = SimpleExoPlayer.Builder(App.context).build()
    }

     */


}