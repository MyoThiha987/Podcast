package com.mth.padc_podcast.network

import com.mth.padc_podcast.data.vos.PodcastDetailVO
import com.mth.padc_podcast.data.vos.RandomPodcastVO
import com.mth.padc_podcast.network.response.GetBestPodcastResponse
import com.mth.padc_podcast.network.response.GetGenreResponse
import com.mth.padc_podcast.network.response.GetUpNextPodcastResponse
import com.mth.padc_podcast.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {

    @GET(GET_JUST_LISTEN)
    fun getRandomPodCast(
        @Header(API_KEY_PARAM) apiKey: String
    ): Observable<RandomPodcastVO>

    @GET(GET_PLAYLIST_INFO_AND_ITEM)
    fun getUpNextPodCast(
        @Header(API_KEY_PARAM) apiKey: String,
        @Path(ID_PARAM) id:String
    ): Observable<GetUpNextPodcastResponse>

    @GET(GET_DETAIL)
    fun fetchDetailEpisodeByID(
        @Header(API_KEY_PARAM) apiKey: String,
        @Path(ID_PARAM) id: String
    ): Observable<PodcastDetailVO>


    @GET(GET_GENRE)
    fun getGenreList(
        @Header(API_KEY_PARAM) apiKey: String,
        @Query(TOP_LEVEL_ONLY_PARAM) top_level_only: Int
    ): Observable<GetGenreResponse>




}