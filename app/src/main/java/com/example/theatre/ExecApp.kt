package com.example.theatre

import android.app.Application
import com.example.theatre.features.spectacles.di.data
import com.example.theatre.features.spectacles.di.domain
import com.example.theatre.features.spectacles.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExecApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExecApp)
            modules(data, domain, presentation)
        }
    }
}