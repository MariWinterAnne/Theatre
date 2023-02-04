package com.example.theatre.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.theatre.features.favourite.data.room.dao.FavouriteDao
import com.example.theatre.features.favourite.data.room.entity.FavouriteEntity

@Database(entities = [FavouriteEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFavouriteDao(): FavouriteDao
}