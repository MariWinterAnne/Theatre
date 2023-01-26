package com.example.theatre.features.favourite.di

import com.example.theatre.features.favourite.data.FavouritesRepoImpl
import com.example.theatre.features.favourite.domain.repo.FavouritesRepo
import com.example.theatre.features.favourite.domain.usecase.FavouritesUseCase
import org.koin.dsl.module

val favouriteDataModule = module {
    factory<FavouritesRepo> { FavouritesRepoImpl(get()) }

    single { FavouritesUseCase(get()) }
}