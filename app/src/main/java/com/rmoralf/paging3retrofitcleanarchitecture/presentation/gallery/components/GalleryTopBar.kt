package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rmoralf.paging3retrofitcleanarchitecture.R

@Composable
fun GalleryTopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        }
    )
}