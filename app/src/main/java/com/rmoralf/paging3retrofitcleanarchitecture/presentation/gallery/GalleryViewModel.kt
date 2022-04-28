package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import com.rmoralf.paging3retrofitcleanarchitecture.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalPagingApi::class)
class GalleryViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {
    val images = useCases.getImages().cachedIn(viewModelScope)
}