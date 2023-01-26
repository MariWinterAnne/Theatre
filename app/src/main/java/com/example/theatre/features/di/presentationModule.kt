package com.example.theatre.features.di

import com.example.theatre.core.presentation.PerformanceDateFormatter
import org.koin.dsl.module

val usefulModule = module {
    factory { PerformanceDateFormatter() }
}