package com.example.theatre

import android.app.Application
import com.example.theatre.core.di.databaseModule
import com.example.theatre.features.di.data
import com.example.theatre.features.di.domain
import com.example.theatre.features.di.networkmodule
import com.example.theatre.features.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheatreApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TheatreApplication)
            modules(databaseModule, networkmodule, data, domain, presentation)
        }
    }
}