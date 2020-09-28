package com.anibalbastias.weatherlib

import com.anibalbastias.weatherlib.data.retrofit.interceptor.AuthenticationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal const val MODULE_NAME = "WeatherLib"

val appModule = Kodein.Module("${MODULE_NAME}Module") {

    bind() from singleton { AuthenticationInterceptor(BuildConfig.GRADLE_WEATHER_APIKEY) }

    bind<HttpLoggingInterceptor>() with singleton {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    bind<Retrofit.Builder>() with singleton { Retrofit.Builder() }

    bind<OkHttpClient.Builder>() with singleton { OkHttpClient.Builder() }

    bind<OkHttpClient>() with singleton {
        val okHttpClient = instance<OkHttpClient.Builder>()
            .addInterceptor(instance<AuthenticationInterceptor>())
            .addInterceptor(instance<HttpLoggingInterceptor>())
        okHttpClient.build()
    }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(BuildConfig.GRADLE_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(instance())
            .build()
    }
}
