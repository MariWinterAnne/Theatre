package com.example.theatre.features.spectacles.di

import com.example.theatre.features.spectacles.presentation.ui.SpectacleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module{
    viewModel {SpectacleViewModel(get())}
}