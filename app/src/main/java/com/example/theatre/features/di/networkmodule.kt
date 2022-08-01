package com.example.theatre.features.di

import com.example.theatre.network.Constants.BASE_URL
import com.example.theatre.network.net.PerformanceApi
import com.example.theatre.network.net.PersonApi
import com.example.theatre.network.net.PosterApi
import com.example.theatre.network.net.TheatreApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkmodule = module {

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
    // TODO: подумать над афишей
    factory { retrofit.create(PosterApi::class.java) }
}