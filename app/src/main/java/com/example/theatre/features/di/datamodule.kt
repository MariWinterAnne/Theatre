package com.example.theatre.features.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import com.example.theatre.network.PerformanceApiMapper
import com.example.theatre.network.PersonApiMapper
import com.example.theatre.network.TheatreApiMapper
import org.koin.dsl.module

val data = module {
    factory { TheatreApiMapper(get()) }
    factory { PersonApiMapper(get()) }
    factory<TheatreRepository> { TheatreRepositoryImpl(get(), get()) }

    factory { PerformanceApiMapper(get()) }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get()) }
}