package com.example.theatre.features.info.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.data.mappers.GetTheatreMapper
import com.example.theatre.features.info.data.mappers.GetTheatreMapperImpl
import com.example.theatre.features.info.domain.repository.TheatreRepository
import org.koin.dsl.module

val data = module {
    factory<GetTheatreMapper> { GetTheatreMapperImpl() }
    factory<TheatreRepository> { TheatreRepositoryImpl(get()) }
}