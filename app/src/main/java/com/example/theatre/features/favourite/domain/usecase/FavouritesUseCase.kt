package com.example.theatre.features.favourite.domain.usecase

import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.domain.model.safeCall
import com.example.theatre.features.favourite.domain.model.FavouriteStuff
import com.example.theatre.features.favourite.domain.repo.FavouritesRepo

class FavouritesUseCase(
    private val dao: FavouritesRepo
) {

    suspend fun getById(id: Int): ResultState<FavouriteStuff> = safeCall { dao.getById(id) }

    suspend fun getAll(): ResultState<List<FavouriteStuff>> = safeCall { dao.getAll() }

    suspend fun delete(fav: FavouriteStuff) = dao.delete(fav)

    suspend fun insert(fav: FavouriteStuff) = dao.insert(fav)

}