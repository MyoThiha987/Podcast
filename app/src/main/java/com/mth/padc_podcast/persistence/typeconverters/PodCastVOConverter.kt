package com.mth.padc_podcast.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/*class PodCastVOConverter {
    @TypeConverter
    fun toString(dataList: DownloadPodcastsVO):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): DownloadPodcastsVO {
        val dataListType = object : TypeToken<DownloadPodcastsVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}

 */