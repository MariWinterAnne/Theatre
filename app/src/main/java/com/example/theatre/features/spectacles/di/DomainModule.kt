package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import org.koin.dsl.module

val performanceDomainModule = module {

    factory { GetPerformanceUseCase(get()) }

}
