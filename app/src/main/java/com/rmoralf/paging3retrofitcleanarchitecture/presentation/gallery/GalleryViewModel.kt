package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Image
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Response
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Response.Loading
import com.rmoralf.paging3retrofitcleanarchitecture.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val _state = mutableStateOf<Response<List<Image>>>(Loading)
    val state: State<Response<List<Image>>> = _state

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            useCases.getImages().collect { response ->
                _state.value = response
            }
        }

    }

}