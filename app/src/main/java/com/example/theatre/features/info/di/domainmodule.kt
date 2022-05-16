package com.example.theatre.features.info.di

import com.example.theatre.features.info.domain.usecases.GetTheatreUseCase
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCaseImpl
import org.koin.dsl.module

val domain = module {
    factory<GetTheatreUseCase> { GetTheatreUseCaseImpl(get()) }
}