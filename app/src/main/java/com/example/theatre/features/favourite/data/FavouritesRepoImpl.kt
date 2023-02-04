package com.example.theatre.features.favourite.data

import com.example.theatre.features.favourite.data.room.dao.FavouriteDao
import com.example.theatre.features.favourite.domain.model.FavouriteStuff
import com.example.theatre.features.favourite.domain.repo.FavouritesRepo
import com.example.theatre.features.favourite.toFavouriteEntity
import com.example.theatre.features.favourite.toFavouriteStuff

class FavouritesRepoImpl(
    private val dao: FavouriteDao
) : FavouritesRepo {
    override suspend fun getById(id: Int): FavouriteStuff =
        dao.getBy(id).toFavouriteStuff()

    override suspend fun getAll(): List<FavouriteStuff> =
        dao.getAll().map { it.toFavouriteStuff() }

    override suspend fun delete(fav: FavouriteStuff) =
        dao.delete(fav.toFavouriteEntity())

    override suspend fun insert(fav: FavouriteStuff) =
        dao.save(fav.toFavouriteEntity())


}