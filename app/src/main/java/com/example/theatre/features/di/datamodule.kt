package com.example.theatre.features.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.data.mappers.*
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import org.koin.dsl.module

val data = module {
    factory<TheatreRepository> { TheatreRepositoryImpl() }
    factory<GetRoleMapper> { GetRoleMapperImpl() }
    factory<GetAgentMapper> { GetAgentMapperImpl() }
    factory<GetPerformanceMapper> { GetPerformanceMapperImpl() }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get(), get(), get()) }
}