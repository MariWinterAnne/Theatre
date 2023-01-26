package com.example.theatre.features.info.di

import com.example.theatre.features.info.presentation.ui.detail.person.PersonDetailViewModel
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDetailViewModel
import com.example.theatre.features.info.presentation.ui.list.person.PersonsListViewModel
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatresListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val infoPresentationModule = module {
    viewModel { TheatresListViewModel(get()) }
    viewModel { TheatreDetailViewModel(get()) }
    viewModel { PersonsListViewModel(get()) }
    viewModel { PersonDetailViewModel(get()) }
}