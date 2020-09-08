package com.mth.padc_podcast.data.models

import android.content.Context
import com.mth.padc_podcast.BuildConfig
import com.mth.padc_podcast.network.PodcastApi
import com.mth.padc_podcast.persistence.database.PodCastDatabase
import com.mth.padc_podcast.root.App
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mPodcastApi: PodcastApi
    protected lateinit var mTheDB: PodCastDatabase


    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)


        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            mOkHttpClient.networkInterceptors().add(httpLoggingInterceptor)
            mOkHttpClient.addInterceptor(ChuckInterceptor(App.context))
        }

        val mClient = mOkHttpClient.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_FIELD)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mClient)
            .build()

        mPodcastApi = retrofit.create(PodcastApi::class.java)

    }

    fun initDatabase(context: Context) {
        mTheDB = PodCastDatabase.getDBInstance(context)
    }
}