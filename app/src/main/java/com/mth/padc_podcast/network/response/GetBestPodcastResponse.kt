package com.mth.padc_podcast.network.response

import com.google.gson.annotations.SerializedName

data class GetBestPodcastResponse(
    @SerializedName("has_next")   val has_next: Boolean,
    @SerializedName("has_previous")  val has_previous: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("listennotes_url") val listennotes_url: String,
    @SerializedName("name") val name: String,
    @SerializedName("next_page_number")val next_page_number: Int,
    @SerializedName("page_number")val page_number: Int,
    @SerializedName("parent_id") val parent_id: Int,
   // @SerializedName("podcasts") val podcasts: List<DownloadPodcastsVO>,
    @SerializedName("previous_page_number")val previous_page_number: Int,
    @SerializedName("total") val total: Int
)