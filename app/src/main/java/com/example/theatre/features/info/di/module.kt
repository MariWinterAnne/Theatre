package com.example.theatre.features.info.di

import com.example.theatre.features.info.presentation.ui.list.TheatreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    viewModel { TheatreViewModel(get()) }
}