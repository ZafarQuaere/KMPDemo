package com.example.kmpdemo.android.postcall

import com.example.kmpdemo.android.postcall.dto.PostRequest
import com.example.kmpdemo.android.postcall.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.logging.*
//import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging


interface PostService {

    suspend fun getPost(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {
        fun create(): PostService {
            return PostServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    /*install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }*/
                }
            )
        }
    }
}