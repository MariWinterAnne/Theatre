package com.example.theatre.features.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.data.api.PersonApiMapper
import com.example.theatre.features.info.data.api.TheatreApiMapper
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.features.poster.data.PosterRepositoryImpl
import com.example.theatre.features.poster.data.api.PosterApiMapper
import com.example.theatre.features.poster.domain.repository.PosterRepository
import com.example.theatre.features.spectacles.api.PerformanceApiMapper
import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import org.koin.dsl.module

val data = module {
    factory { TheatreApiMapper(get()) }
    factory { PersonApiMapper(get()) }
    factory<TheatreRepository> { TheatreRepositoryImpl(get(), get()) }

    factory { PerformanceApiMapper(get()) }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get()) }

    factory { PosterApiMapper(get()) }
    factory<PosterRepository> { PosterRepositoryImpl(get()) }
}