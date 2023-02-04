package com.example.theatre.features.poster.di

import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailsViewModel
import com.example.theatre.features.poster.presentation.ui.list.PostersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val posterPresentationModule = module {

    viewModel { PostersListViewModel(get()) }
    viewModel { PosterDetailsViewModel(get()) }

}