package com.rmoralf.paging3retrofitcleanarchitecture.data.network.remote

import com.rmoralf.paging3retrofitcleanarchitecture.data.network.entities.ApiImage
import retrofit2.http.GET

interface ImagesService {
    @GET("/v2/list")
    suspend fun getImages(
    ): List<ApiImage>
}