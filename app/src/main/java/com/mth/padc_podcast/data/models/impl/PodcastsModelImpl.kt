package com.mth.padc_podcast.data.models.impl

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.LiveData
import com.mth.padc_podcast.data.models.BaseModel
import com.mth.padc_podcast.data.models.PodcastsModel
import com.mth.padc_podcast.data.vos.*
import com.mth.padc_podcast.utils.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

object PodcastsModelImpl : BaseModel(), PodcastsModel {
    private var compositeDisposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun getDetailPodcast(
        episodeId: String,
        onError: (String) -> Unit
    ): Observable<PodcastDetailVO> {
        return mPodcastApi.fetchDetailEpisodeByID(PARAM_API_ACCESS_TOKEN, episodeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getGenreList(onError: (String) -> Unit): LiveData<List<CategoryVO>> {
        return mTheDB.generDao().getAllGenreList()
    }

    @SuppressLint("CheckResult")
    override fun getCategoryFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mPodcastApi.getGenreList(PARAM_API_ACCESS_TOKEN, top_level_only)
            .map { it.genre.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.let { mTheDB.generDao().saveGenre(it) }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    @SuppressLint("CheckResult")
    override fun getRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: (datavo: RandomPodcastVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mPodcastApi.getRandomPodCast(PARAM_API_ACCESS_TOKEN)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.let { data ->
                    mTheDB.randomPodCastDao().insertRandomPodCast(data)
                }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun startDownloadPodcast(
        context: Context,
        upNextPodcastVO: UpNextPodcastVO,
        downloadPodcastVO: DownloadPodcastVO
    ) {
        startDownlod(
            context,
            downloadPodcastVO.copy(
                upNextPodcastVO.id,
                upNextPodcastVO.dataVO.podcast.title,
                upNextPodcastVO.dataVO.audio,
                upNextPodcastVO.dataVO.description,
                upNextPodcastVO.dataVO.podcast
            )
        )
    }

    override fun getAllDownloadPodcastList(): LiveData<List<DownloadPodcastVO>> {
        return mTheDB.downloadPodcastDao().getAllDownloadPodcast()
    }

    override fun getRandomPodCast(onError: (String) -> Unit): LiveData<RandomPodcastVO> {
        return mTheDB.randomPodCastDao().getRandomPodCast()
    }

    @SuppressLint("CheckResult")
    override fun getUpNextPodCastListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mPodcastApi.getUpNextPodCast(PARAM_API_ACCESS_TOKEN, "m1pe7z60bsw")
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.let { data ->
                    mTheDB.upNextPodCastDao().insertUpNextPodCastList(data.items)
                }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override var downloadVo: DownloadPodcastVO? = null


    override fun getUpNextPodCast(onError: (String) -> Unit): LiveData<List<UpNextPodcastVO>> {
        return mTheDB.upNextPodCastDao().getAllUpNextPodCastList()
    }

    private var onComplete: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == DownloadManager.ACTION_DOWNLOAD_COMPLETE)

                downloadVo?.let {
                    mTheDB.downloadPodcastDao().downloadPodcast(it)
                        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe {

                        }.let {
                            compositeDisposable.addAll(it)
                        }
                }

            context?.unregisterReceiver(this)
        }
    }

    fun startDownlod(context: Context, upNextPodcastVO: DownloadPodcastVO) {

        val request = DownloadManager.Request(Uri.parse(upNextPodcastVO.audio))
            .apply {
                setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                setTitle(upNextPodcastVO.podcast.title)
                setDescription(upNextPodcastVO.description)
                allowScanningByMediaScanner()
                setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    "podcast/${upNextPodcastVO.podcast.title.trim()}.mp3"
                )

                context.registerReceiver(
                    onComplete,
                    IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
                )
                downloadVo = upNextPodcastVO
            }
        val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }

}