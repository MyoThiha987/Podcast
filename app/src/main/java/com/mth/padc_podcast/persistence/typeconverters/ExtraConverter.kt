package com.mth.padc_podcast.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/*class ExtraConverter {
    @TypeConverter
    fun toString(dataList: Extra):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): Extra{
        val dataListType = object : TypeToken<Extra>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}

 */