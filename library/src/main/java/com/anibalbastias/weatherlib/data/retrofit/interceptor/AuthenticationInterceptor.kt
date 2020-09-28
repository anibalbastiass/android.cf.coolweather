package com.anibalbastias.weatherlib.data.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.request().let {
        val url = it.url.newBuilder()
            .addQueryParameter("apikey", apiKey)
            .build()

        val newRequest = it.newBuilder()
            .url(url)
            .build()

        chain.proceed(newRequest)
    }
}
