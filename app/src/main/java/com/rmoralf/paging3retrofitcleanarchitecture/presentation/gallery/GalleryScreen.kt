package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmoralf.paging3retrofitcleanarchitecture.core.utils.Utils.Companion.printError
import com.rmoralf.paging3retrofitcleanarchitecture.domain.model.Response.*
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.components.ProgressBar
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryEmptyList
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryGrid
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryTopBar

@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            GalleryTopBar()
        }
    ) {
        when (val imagesResponse = viewModel.state.value) {
            is Loading -> ProgressBar()
            is Success -> {
                val imageList = imagesResponse.data
                if (imageList.isNullOrEmpty()) {
                    GalleryEmptyList()
                } else {
                    GalleryGrid(imageList = imageList)
                }
            }
            is Error -> printError(imagesResponse.message)
        }

    }
}