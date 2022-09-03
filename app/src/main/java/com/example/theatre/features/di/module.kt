package com.example.theatre.features.di

import com.example.theatre.core.utils.PerformanceDateFormatter
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDetailViewModel
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDetailViewModel
import com.example.theatre.features.info.presentation.ui.list.person.PersonViewModel
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatreViewModel
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailsViewModel
import com.example.theatre.features.poster.presentation.ui.list.PostersViewModel
import com.example.theatre.features.spectacles.presentation.ui.list.SpectacleViewModel
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    viewModel { TheatreViewModel(get()) }
    viewModel { TheatreDetailViewModel(get()) }
    viewModel { PersonViewModel(get()) }
    viewModel { PersonDetailViewModel(get()) }
    viewModel { SpectacleViewModel(get()) }
    viewModel { SpectacleDetailsViewModel(get()) }
    viewModel { PostersViewModel(get()) }
    viewModel { PosterDetailsViewModel(get()) }
    factory { PerformanceDateFormatter() }
}