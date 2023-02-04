package com.example.theatre.features.poster.di

import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase
import org.koin.dsl.module

val posterDomainModule = module {

    factory { GetPosterUseCase(get()) }

}
