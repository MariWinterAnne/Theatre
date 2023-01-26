package com.example.theatre.features.di

import GetTheatreUseCase
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import org.koin.dsl.module

val domain = module {
    factory { GetTheatreUseCase(get()) }
    factory { GetPersonUseCase(get()) }
    factory { GetPerformanceUseCase(get()) }
    factory { GetPosterUseCase(get()) }
}