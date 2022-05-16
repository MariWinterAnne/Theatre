package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.data.mappers.*
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import org.koin.dsl.module

val data = module {
    factory<GetRoleMapper> { GetRoleMapperImpl() }
    factory<GetAgentMapper> { GetAgentMapperImpl() }
    factory<GetPerformanceMapper> { GetPerformanceMapperImpl() }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get(), get(), get()) }
}