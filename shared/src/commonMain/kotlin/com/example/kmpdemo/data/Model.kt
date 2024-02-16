package com.example.kmpdemo.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PostRequest(
    val title: String,
    val body: String,
    val userId: Int
)

@Serializable
internal data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)