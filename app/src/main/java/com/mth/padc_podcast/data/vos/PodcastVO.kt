package com.mth.padc_podcast.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "randompodcast")
data class RandomPodcastVO(
    @SerializedName("id") @PrimaryKey(autoGenerate = false) val id : String,
    @SerializedName("audio") val audio : String,
    @SerializedName("link") val link : String,
    @SerializedName("description") val description : String,
    @Embedded @SerializedName("podcast") val podcast : PodcastVO

)

data class PodcastVO(
    @SerializedName("id") val pid : String="",
    @SerializedName("image") val image: String="",
    @SerializedName("listennotes_url") val listennotes_url: String="",
    @SerializedName("publisher") val publisher: String="",
    @SerializedName("thumbnail") val thumbnail: String="",
    @SerializedName("title") val title: String=""
)