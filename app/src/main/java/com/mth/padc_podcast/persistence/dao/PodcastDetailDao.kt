package com.mth.padc_podcast.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_podcast.data.vos.PodcastDetailVO


/*@Dao
interface PodcastDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(data: PodcastDetailVO)

    @Query("select * from detail WHERE id = :detail_id")
    fun getAllDetailDataByEpisodeID(detail_id: String): LiveData<PodcastDetailVO>


}

 */