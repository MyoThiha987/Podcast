package com.mth.padc_podcast.data.models

import android.content.Context
import androidx.lifecycle.LiveData
import com.mth.padc_podcast.data.vos.*
import io.reactivex.Observable


interface PodcastsModel {

    var downloadVo : DownloadPodcastVO?
    fun getUpNextPodCast(onError: (String) -> Unit): LiveData<List<UpNextPodcastVO>>
    fun getUpNextPodCastListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    fun getDetailPodcast(
        episodeId: String,
        onError: (String) -> Unit
    ) : Observable<PodcastDetailVO>

    fun getGenreList(onError: (String) -> Unit): LiveData<List<CategoryVO>>
    fun getCategoryFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getRandomPodCast(onError: (String) -> Unit): LiveData<RandomPodcastVO>
    fun getRandomPodCastFromApiAndSaveToDatabase(
        onSuccess: (datavo: RandomPodcastVO) -> Unit,
        onError: (String) -> Unit
    )

    fun startDownloadPodcast(context: Context,upNextPodcastVO: UpNextPodcastVO,downloadPodcastVO: DownloadPodcastVO)
    fun getAllDownloadPodcastList() : LiveData<List<DownloadPodcastVO>>

}