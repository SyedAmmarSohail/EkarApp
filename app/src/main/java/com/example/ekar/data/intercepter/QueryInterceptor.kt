package com.example.ekar.data.intercepter

import com.example.ekar.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


class QueryInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("key", BuildConfig.API_KEY)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}