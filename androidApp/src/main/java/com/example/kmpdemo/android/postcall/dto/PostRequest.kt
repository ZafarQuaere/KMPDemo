package com.example.kmpdemo.android.postcall.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val title: String,
    val body: String,
    val userId: Int
)
