package com.mth.padc_podcast.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mth.padc_podcast.data.vos.CategoryVO

class GenreListConverter {
    @TypeConverter
    fun toString(dataList: List<CategoryVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): List<CategoryVO> {
        val dataListType = object : TypeToken<List<CategoryVO>>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}
