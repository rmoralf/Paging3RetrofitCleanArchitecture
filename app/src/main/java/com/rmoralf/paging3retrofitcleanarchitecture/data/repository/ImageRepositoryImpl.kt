package com.rmoralf.paging3retrofitcleanarchitecture.data.repository

import com.rmoralf.paging3retrofitcleanarchitecture.data.network.remote.ImagesService
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Response.*
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.toDomain
import com.rmoralf.paging3retrofitcleanarchitecture.domain.repository.ImageRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class ImageRepositoryImpl @Inject constructor(
    private val service: ImagesService
) : ImageRepository {
    override suspend fun getImages() = flow {
        try {
            emit(Loading)
            val imageList = service
                .getImages()
                .map { it.toDomain() }
            emit(Success(imageList))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }
}