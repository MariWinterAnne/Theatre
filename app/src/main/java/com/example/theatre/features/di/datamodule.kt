package com.example.theatre.features.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.data.mappers.GetPersonMapper
import com.example.theatre.features.info.data.mappers.GetPersonMapperImpl
import com.example.theatre.features.info.data.mappers.GetTheatreMapper
import com.example.theatre.features.info.data.mappers.GetTheatreMapperImpl
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.features.spectacles.data.PerformanceRepositoryImpl
import com.example.theatre.features.spectacles.data.mappers.*
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository
import org.koin.dsl.module

val data = module {
    factory<GetPersonMapper> { GetPersonMapperImpl() }
    factory<GetTheatreMapper> { GetTheatreMapperImpl() }
    factory<TheatreRepository> { TheatreRepositoryImpl(get(), get()) }

    factory<GetRoleMapper> { GetRoleMapperImpl() }
    factory<GetAgentMapper> { GetAgentMapperImpl() }
    factory<GetPerformanceMapper> { GetPerformanceMapperImpl() }
    factory<PerformanceRepository> { PerformanceRepositoryImpl(get(), get(), get()) }
}