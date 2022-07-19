package com.example.theatre.features.di

import com.example.theatre.network.Constants.BASE_URL
import com.example.theatre.network.net.PerformanceApi
import com.example.theatre.network.net.PersonApi
import com.example.theatre.network.net.TheatreApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkmodule = module {

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    factory { retrofit.create(PersonApi::class.java) }
    factory { retrofit.create(TheatreApi::class.java) }
    factory { retrofit.create(PerformanceApi::class.java) }
}