package com.mth.padc_podcast.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mth.padc_podcast.persistence.typeconverters.DataConverter
import com.mth.padc_podcast.persistence.typeconverters.DataDConverter
import java.io.Serializable

@Entity(tableName = "upnextpodcast")
@TypeConverters(DataConverter::class)
data class UpNextPodcastVO(
    @SerializedName("id") @PrimaryKey(autoGenerate = false) val id: Int,
    @SerializedName("data") @Embedded val dataVO: DataVO
):Serializable

data class DataVO(
    @SerializedName("audio") val audio: String,
    @SerializedName("description") val description : String,
    @SerializedName("audio_length_sec") val audio_length_sec: Int,
    @SerializedName("podcast") @Embedded val podcast: PodcastVO
)

