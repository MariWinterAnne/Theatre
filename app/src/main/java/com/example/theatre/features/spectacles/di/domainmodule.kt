package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCaseImpl
import org.koin.dsl.module

val domain = module {
    factory<GetPerformanceUseCase> { GetPerformanceUseCaseImpl(get()) }
}