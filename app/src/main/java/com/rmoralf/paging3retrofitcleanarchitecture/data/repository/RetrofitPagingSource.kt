package com.rmoralf.paging3retrofitcleanarchitecture.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rmoralf.paging3retrofitcleanarchitecture.data.network.remote.ImagesService
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Image
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.toDomain

class RetrofitPagingSource(
    private val service: ImagesService
) : PagingSource<Int, Image>() {
    override fun getRefreshKey(state: PagingState<Int, Image>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        return try {
            val currentPage = service.getImages(params.key ?: 1).map { it.toDomain() }
            val nextPage = if (currentPage.isEmpty()) {
                null
            } else {
                params.key?.let { it + 1 } ?: 2
            }
            LoadResult.Page(
                data = currentPage,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}