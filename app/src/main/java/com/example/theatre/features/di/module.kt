package com.example.theatre.features.di

import com.example.theatre.features.info.presentation.ui.list.person.PersonViewModel
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatreViewModel
import com.example.theatre.features.spectacles.presentation.ui.SpectacleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module{
    viewModel { TheatreViewModel(get()) }
    viewModel { PersonViewModel(get()) }

    viewModel {SpectacleViewModel(get())}
}