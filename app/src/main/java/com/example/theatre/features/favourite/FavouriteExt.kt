package com.example.theatre.features.favourite

import com.example.theatre.features.favourite.data.room.entity.FavouriteEntity
import com.example.theatre.features.favourite.domain.model.FavouriteStuff

fun FavouriteEntity.toFavouriteStuff(): FavouriteStuff = FavouriteStuff(
    id = id
)

fun FavouriteStuff.toFavouriteEntity(): FavouriteEntity = FavouriteEntity(
    id = id
)