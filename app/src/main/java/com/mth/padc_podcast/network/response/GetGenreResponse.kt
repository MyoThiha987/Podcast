package com.mth.padc_podcast.network.response

import com.google.gson.annotations.SerializedName
import com.mth.padc_podcast.data.vos.CategoryVO

data class GetGenreResponse(
    @SerializedName("genres") val genre: List<CategoryVO>
)