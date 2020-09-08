package com.mth.padc_podcast.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mth.padc_podcast.data.vos.DataVO

class DataConverter {
    @TypeConverter
    fun toString(dataList: List<DataVO>): String {
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr: String): List<DataVO> {
        val dataListType = object : TypeToken<List<DataVO>>() {}.type
        return Gson().fromJson(ListJsonStr, dataListType)
    }
}

class DataDConverter {
    @TypeConverter
    fun toString(dataList: List<DataVO>): String {
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr: String): List<DataVO> {
        val dataListType = object : TypeToken<List<DataVO>>() {}.type
        return Gson().fromJson(ListJsonStr, dataListType)
    }
}

