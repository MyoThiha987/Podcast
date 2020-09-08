package com.mth.padc_podcast.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_podcast.data.vos.RandomPodcastVO

@Dao
interface RandomPodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRandomPodCast(podcast: RandomPodcastVO) : Long

    @Query("SELECT * FROM randompodcast")
    fun getRandomPodCast(): LiveData<RandomPodcastVO>


}