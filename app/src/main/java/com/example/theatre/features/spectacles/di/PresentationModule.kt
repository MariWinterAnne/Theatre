package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsViewModel
import com.example.theatre.features.spectacles.presentation.ui.list.SpectaclesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val performancePresentationModule = module {

    viewModel { SpectaclesListViewModel(get()) }
    viewModel { SpectacleDetailsViewModel(get()) }

}