package com.example.kmpdemo

import com.example.kmpdemo.data.PostRequest
import com.example.kmpdemo.data.PostResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class ApiService: KtorApi() {

    suspend fun callPostApi(path: String,request: PostRequest): PostResponse = client.post {
        endPoint(path = path)
        setBody(request)
    }.body()
}