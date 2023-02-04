package com.example.theatre.features.poster.di

import com.example.theatre.features.poster.data.PosterRepositoryImpl
import com.example.theatre.features.poster.data.api.PosterApiMapper
import com.example.theatre.features.poster.domain.repository.PosterRepository
import org.koin.dsl.module

val posterDataModule = module {

    factory { PosterApiMapper(get()) }
    factory<PosterRepository> { PosterRepositoryImpl(get()) }

}