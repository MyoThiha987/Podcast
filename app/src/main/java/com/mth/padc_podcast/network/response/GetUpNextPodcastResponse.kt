package com.mth.padc_podcast.network.response

import com.google.gson.annotations.SerializedName
import com.mth.padc_podcast.data.vos.UpNextPodcastVO

data class GetUpNextPodcastResponse(
    @SerializedName("items") val items : List<UpNextPodcastVO>
)