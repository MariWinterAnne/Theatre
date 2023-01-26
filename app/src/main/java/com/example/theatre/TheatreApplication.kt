package com.example.theatre

import android.app.Application
import com.example.theatre.core.di.databaseModule
import com.example.theatre.features.di.networkModule
import com.example.theatre.features.di.usefulModule
import com.example.theatre.features.favourite.di.favouriteModules
import com.example.theatre.features.info.di.infoModules
import com.example.theatre.features.poster.di.posterModules
import com.example.theatre.features.spectacles.di.performanceModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TheatreApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TheatreApplication)
            modules(favouriteModules)
            modules(infoModules)
            modules(posterModules)
            modules(performanceModules)
            modules(databaseModule, networkModule, usefulModule)
        }
    }
}