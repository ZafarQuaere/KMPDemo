package com.example.kmpdemo.android

import androidx.lifecycle.ViewModel
import com.example.kmpdemo.LLMApiClient

class MainViewModel : ViewModel() {
    val tag = "MainViewModel"

  /*  private val remoteConfig = RemoteConfig(
//        baseUrl = "https://api.spacexdata.com/v4",
        baseUrl = "https://jsonplaceholder.typicode.com",
        commonHeaders = mapOf(
            "Content-Type" to "application/json",
        ),
        commonQueryParams = mapOf(
            "platform" to "android",
            "version" to "1.0.0"
        ),
        useHttpsProtocol = true,
        connectTimeOut = 15_000,
        requestTimeOut = 15_000,
        socketTimeOut = 15_000,
        isDebugEnv = true,
        enableCronet = true
    )
*/

  /*  fun getRemoteSource(context: AppContext): NetClient {
        return NetClient.Builder(context)
            .setRemoteConfig(remoteConfig)
            .addInterceptor(Interceptor { chain ->
                chain.requestBuilder.headerBuilder.appendHeader("test_header", "a")
                val call = chain.proceed(chain.requestBuilder)
                Log.d(tag, "http response code:${call.response.statusCode}, url:${call.request.url}")
                return@Interceptor call
            })
            .addInterceptor(Interceptor { chain ->
                val headerValue = chain.requestBuilder.headerBuilder.getValue("test_header")
                assert(headerValue == "a") { "interceptor execute issue, header is not a" }
                Log.d(tag, "interceptor get added header: test_header=${headerValue}")
                Log.d(tag, "execute interceptor thread:${Thread.currentThread().name}")
                chain.proceed(chain.requestBuilder)
            })
            .build()
    }*/

//    fun postToRemoteSource (): NetClient {
//        val requestBody = mapOf(
//            "title" to "foo",
//            "body" to "bar",
//            "userId" to 1
//        )
////        val requestBody = PostBody("foo", "bar", 1)
////        remoteConfig.bodyParams = requestBody
//
//        remoteConfig.bodyParams = requestBody
//
//        return NetClient.Builder(context)
//            .setRemoteConfig(remoteConfig)
//            .addInterceptor(Interceptor { chain ->
//                chain.requestBuilder.headerBuilder.appendHeader("Content-Type", "application/json; charset=UTF-8")
//                val call = chain.proceed(chain.requestBuilder)
//                Log.d(tag, "http response code:${call.response.statusCode}, url:${call.request.url}")
//                return@Interceptor call
//            })
//            .addInterceptor(Interceptor { chain ->
//                val headerValue = chain.requestBuilder.headerBuilder.getValue("Content-Type")
//                assert(headerValue == "application/json; charset=UTF-8") { "interceptor execute issue, header is not a" }
//                Log.d(tag, "interceptor get added header: test_header = $headerValue")
//                Log.d(tag, "execute interceptor thread:${Thread.currentThread().name}")
//                chain.proceed(chain.requestBuilder)
//            })
//            .build()
//    }


    fun init() {

    }

    fun callPostApi(path: String): Any {
        LLMApiClient().callPostApi(path)
        return "Loading..."
    }

}
