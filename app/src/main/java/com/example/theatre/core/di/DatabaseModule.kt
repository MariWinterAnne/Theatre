package com.example.theatre.core.di

import androidx.room.Room
import com.example.theatre.core.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "database").build()
    }

    single {
        get<AppDatabase>().getFavouriteDao()
    }
}