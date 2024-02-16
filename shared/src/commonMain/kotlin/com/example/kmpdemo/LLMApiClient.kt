package com.example.kmpdemo

import com.example.kmpdemo.data.PostRequest
import com.example.kmpdemo.data.PostResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LLMApiClient {

    @OptIn(DelicateCoroutinesApi::class)
    fun callPostApi(path: String) {
        GlobalScope.launch {
            val callPostApi: PostResponse = ApiService().callPostApi(path, PostRequest("foo", "bar", 1))
            println(callPostApi.title + " " + callPostApi.body + " " + callPostApi.userId + " " + callPostApi.id)
        }
    }
}
