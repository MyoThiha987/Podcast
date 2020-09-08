package com.mth.padc_podcast.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_podcast.data.vos.DownloadPodcastVO
import com.mth.padc_podcast.data.vos.UpNextPodcastVO
import io.reactivex.Completable

@Dao
interface DownloadPodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun downloadPodcast(downloadPodcasts: DownloadPodcastVO) : Completable

    @Query("select * from downloadpodcast")
    fun getAllDownloadPodcast(): LiveData<List<DownloadPodcastVO>>

}