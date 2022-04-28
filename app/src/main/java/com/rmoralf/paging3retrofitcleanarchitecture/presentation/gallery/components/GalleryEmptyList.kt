package com.rmoralf.paging3retrofitcleanarchitecture.presentation.gallery.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.rmoralf.paging3retrofitcleanarchitecture.R

@Composable
fun GalleryEmptyList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.no_images),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}