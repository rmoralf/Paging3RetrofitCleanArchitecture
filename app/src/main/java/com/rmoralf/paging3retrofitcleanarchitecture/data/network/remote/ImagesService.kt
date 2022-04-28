package com.rmoralf.paging3retrofitcleanarchitecture.data.network.remote

import com.rmoralf.paging3retrofitcleanarchitecture.data.network.entities.ApiImage
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesService {
    @GET("/v2/list")
    suspend fun getImages(
        @Query("page") page: Int? = 1
    ): List<ApiImage>
}