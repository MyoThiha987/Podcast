package com.mth.padc_podcast.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_podcast.data.vos.UpNextPodcastVO

@Dao
interface UpNextPodCastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpNextPodCastList(data: List<UpNextPodcastVO>)

    @Query("select * from upnextpodcast")
    fun getAllUpNextPodCastList(): LiveData<List<UpNextPodcastVO>>

}

