package com.example.theatre.features.favourite.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favourites"
)
data class FavouriteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int
)
