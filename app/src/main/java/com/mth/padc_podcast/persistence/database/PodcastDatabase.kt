package com.mth.padc_podcast.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mth.padc_podcast.data.vos.*
import com.mth.padc_podcast.persistence.dao.*

@Database(
    entities = [RandomPodcastVO::class,UpNextPodcastVO::class,CategoryVO::class,DownloadPodcastVO::class],
    version = 1,
    exportSchema = false
)
abstract class PodCastDatabase : RoomDatabase() {
    companion object {

        var INSTANCE: PodCastDatabase? = null
        const val DATABASE_NAME = "Podcast.DB"


        fun getDBInstance(context: Context): PodCastDatabase {
            INSTANCE = Room.databaseBuilder(context,PodCastDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            return INSTANCE as PodCastDatabase

        }
    }

    abstract fun downloadPodcastDao(): DownloadPodcastDao
    abstract fun generDao(): GenreDao
    abstract fun upNextPodCastDao(): UpNextPodCastDao
    abstract fun randomPodCastDao(): RandomPodcastDao
}