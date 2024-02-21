package com.example.kmpdemo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PostRequest(
    val title: String,
    val body: String,
    val userId: Int
)

@Serializable
data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

@Serializable
data class Register(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)

@Serializable
data class RegisterResponse(
    val id: Int,
    val token: String
)