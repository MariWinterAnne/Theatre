package com.example.theatre.features.di

import com.example.theatre.core.presentation.PerformanceDateFormatter
import com.example.theatre.core.presentation.ui.LayoutErrorHandler
import org.koin.dsl.module

val usefulModule = module {
    factory { PerformanceDateFormatter() }
    factory { LayoutErrorHandler() }
}