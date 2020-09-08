package com.mth.padc_podcast.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "downloadpodcast")
data class DownloadPodcastVO(
    @SerializedName("id") @PrimaryKey(autoGenerate = false) val did: Int=0,
    @SerializedName("title") val dtitle :String="",
    @SerializedName("audio") val audio: String="",
    @SerializedName("description") val description : String="",
    @SerializedName("podcast")
    @Embedded
    val podcast: PodcastVO=PodcastVO()
)
