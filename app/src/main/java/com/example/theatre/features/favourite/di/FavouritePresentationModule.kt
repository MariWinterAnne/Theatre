package com.example.theatre.features.favourite.di

import com.example.theatre.features.favourite.presentation.ui.detail.FavouriteDetailsViewModel
import com.example.theatre.features.favourite.presentation.ui.list.FavouriteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favouritePresentationModule = module {
    viewModel { FavouriteListViewModel(get()) }
    viewModel { FavouriteDetailsViewModel(get()) }
}