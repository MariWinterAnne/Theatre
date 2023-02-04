package com.example.theatre.features.info.di

import com.example.theatre.features.info.data.TheatreRepositoryImpl
import com.example.theatre.features.info.data.api.PersonApiMapper
import com.example.theatre.features.info.data.api.TheatreApiMapper
import com.example.theatre.features.info.domain.repository.TheatreRepository
import org.koin.dsl.module

val infoDataModule = module {
    factory { TheatreApiMapper(get()) }
    factory { PersonApiMapper(get()) }
    factory<TheatreRepository> { TheatreRepositoryImpl(get(), get()) }
}