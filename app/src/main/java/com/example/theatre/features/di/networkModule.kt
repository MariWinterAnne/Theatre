package com.example.theatre.features.di

import com.example.theatre.features.Constants.BASE_URL
import com.example.theatre.features.info.data.api.PersonApi
import com.example.theatre.features.info.data.api.TheatreApi
import com.example.theatre.features.poster.data.api.PosterApi
import com.example.theatre.features.spectacles.data.api.PerformanceApi
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        .callTimeout(2, TimeUnit.MINUTES)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)

    builder.client(httpClient.build())
    val retrofit: Retrofit = builder.build()

    factory { retrofit.create(PersonApi::class.java) }
    factory { retrofit.create(TheatreApi::class.java) }
    factory { retrofit.create(PerformanceApi::class.java) }
    factory { retrofit.create(PosterApi::class.java) }
}