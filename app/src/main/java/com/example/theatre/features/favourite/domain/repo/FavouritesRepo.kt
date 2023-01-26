package com.example.theatre.features.favourite.domain.repo

import com.example.theatre.features.favourite.domain.model.FavouriteStuff

interface FavouritesRepo {
    suspend fun getById(id: Int): FavouriteStuff
    suspend fun getAll(): List<FavouriteStuff>
    suspend fun delete(fav: FavouriteStuff)
    suspend fun insert(fav: FavouriteStuff)
}