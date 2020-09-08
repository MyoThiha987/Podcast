package com.mth.padc_podcast.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mth.padc_podcast.persistence.typeconverters.GenreListConverter

@Entity(tableName = "genre")
@TypeConverters(GenreListConverter::class)
data class CategoryVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name")   val name: String,
    @SerializedName("parent_id")   val parent_id: Int
)