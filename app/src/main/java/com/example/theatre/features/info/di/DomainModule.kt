package com.example.theatre.features.info.di

import GetTheatreUseCase
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import org.koin.dsl.module

val infoDomainModule = module {
    factory { GetTheatreUseCase(get()) }
    factory { GetPersonUseCase(get()) }
}