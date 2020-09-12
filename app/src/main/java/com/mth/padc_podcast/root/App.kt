package com.mth.padc_podcast.root

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.SimpleExoPlayer

import com.mth.padc_podcast.data.models.impl.PodcastsModelImpl
import io.reactivex.plugins.RxJavaPlugins

class App : Application() {

    companion object{
        lateinit var context : Context
        //var simpleExoplayer: SimpleExoPlayer? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        RxJavaPlugins.setErrorHandler { throwable ->
            run { Log.d("RX error : ", "Rx error : ${throwable.localizedMessage}") } }
        PodcastsModelImpl.initDatabase(context)
        //simpleExoplayer = SimpleExoPlayer.Builder(context).build()


    }
}