package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.data.api.PerformanceApiMapper
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import org.koin.dsl.module

val performanceDataModule = module {

    factory { PerformanceApiMapper(get()) }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get()) }

}