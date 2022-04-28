package com.rmoralf.paging3retrofitcleanarchitecture.domain.repository

import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Image
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getImages(): Flow<Response<List<Image>>>
}