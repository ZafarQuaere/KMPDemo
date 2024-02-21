package com.example.kmpdemo

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class ApiService: KtorApi() {

    suspend inline fun <reified T: Any> callPostApi(path: String, request: Any): T = client.post{
        endPoint(path = path)
        setBody(request)
    }.body<T>()
}