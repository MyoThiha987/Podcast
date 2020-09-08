package com.mth.padc_podcast.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mth.padc_podcast.data.vos.CategoryVO

@Dao
interface GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveGenre(data: List<CategoryVO>)

    @Query("select * from genre")
    fun getAllGenreList(): LiveData<List<CategoryVO>>

}