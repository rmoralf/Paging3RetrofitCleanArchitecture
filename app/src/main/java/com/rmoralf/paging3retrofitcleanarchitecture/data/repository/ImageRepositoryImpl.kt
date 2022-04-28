package com.rmoralf.paging3retrofitcleanarchitecture.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rmoralf.paging3retrofitcleanarchitecture.domain.repository.ImageRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class ImageRepositoryImpl @Inject constructor(
    private val service: RetrofitPagingSource,
) : ImageRepository {

    override fun getImages() = Pager(
        config = PagingConfig(
            pageSize = 1
        )
    ) {
        service
    }.flow

}