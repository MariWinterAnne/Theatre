package com.example.theatre.features.di

import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import com.example.theatre.features.info.domain.usecases.GetPersonUseCaseImpl
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCase
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCaseImpl
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCaseImpl
import org.koin.dsl.module

val domain = module {
    factory<GetTheatreUseCase> { GetTheatreUseCaseImpl(get()) }
    factory<GetPersonUseCase> { GetPersonUseCaseImpl(get()) }

    factory<GetPerformanceUseCase> { GetPerformanceUseCaseImpl(get()) }
}