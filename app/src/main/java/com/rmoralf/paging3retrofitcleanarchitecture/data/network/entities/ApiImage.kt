package com.rmoralf.paging3retrofitcleanarchitecture.data.network.entities

data class ApiImage(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
)

