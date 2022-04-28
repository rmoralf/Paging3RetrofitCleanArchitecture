package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.rmoralf.paging3retrofitcleanarchitecture.core.utils.Utils.Companion.printError
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.components.ProgressBar
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryEmptyList
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryGrid
import com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components.GalleryTopBar

@OptIn(ExperimentalPagingApi::class)
@Composable
fun GalleryScreen(
    viewModel: GalleryViewModel = hiltViewModel()
) {
    val imageList = viewModel.images.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            GalleryTopBar()
        }
    ) {
        if (imageList.itemCount > 0) {
            GalleryGrid(imageList = imageList)
        } else {
            GalleryEmptyList()
        }
        imageList.apply {
            when {
                loadState.refresh is LoadState.Loading -> ProgressBar()
                loadState.refresh is LoadState.Error -> printError(imageList.loadState.refresh as LoadState.Error)
                loadState.append is LoadState.Loading -> ProgressBar()
                loadState.append is LoadState.Error -> printError(imageList.loadState.append as LoadState.Error)
            }
        }
    }
}