package com.rmoralf.paging3retrofitcleanarchitecture.domain.usecases

import com.rmoralf.paging3retrofitcleanarchitecture.domain.repository.ImageRepository

class GetImages(
    private val repository: ImageRepository
) {
    suspend operator fun invoke() = repository.getImages()
}