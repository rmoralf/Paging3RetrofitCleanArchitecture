package com.rmoralf.paging3retrofitcleanarchitecture.domain.repository

import androidx.paging.PagingData
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(): Flow<PagingData<Image>>
}