package com.mth.padc_podcast.data.vos

import com.google.gson.annotations.SerializedName

data class PodcastDetailVO(
    @SerializedName("id") val id: String,
    @SerializedName("audio")  val audio: String,
    @SerializedName("audio_length_sec")  val audio_length_sec: Long,
    @SerializedName("description") val description: String,
    @SerializedName("image")  val image: String,
    @SerializedName("podcast") val podcast: PodcastVO
)