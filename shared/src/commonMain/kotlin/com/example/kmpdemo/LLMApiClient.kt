package com.example.kmpdemo

import com.example.kmpdemo.data.PostRequest
import com.example.kmpdemo.data.PostResponse
import com.example.kmpdemo.data.Register
import com.example.kmpdemo.data.RegisterResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LLMApiClient {

   suspend fun callPostApi(path: String) : PostResponse? {
        var response : PostResponse? = null
            response = ApiService().callPostApi(path, PostRequest("fooool", "barbarbar", 1))
            println("Title >> "+response?.title + " body >> " + response?.body + "  userId >>" + response?.userId + " id >>> " + response?.id)
        return response
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun callRegisterApi(path: String): RegisterResponse? {
        var response: RegisterResponse? = null
        GlobalScope.launch {
            response = ApiService().callPostApi(
                path,
                Register("eve.holt@reqres.in", "pistol")
            ) as RegisterResponse
            println("id >> " + response?.id + " token >> " + response?.token)
        }
        return response
    }
}
