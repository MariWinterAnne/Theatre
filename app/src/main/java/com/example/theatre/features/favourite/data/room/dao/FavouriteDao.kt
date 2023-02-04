package com.example.theatre.features.favourite.data.room.dao

import androidx.room.*
import com.example.theatre.features.favourite.data.room.entity.FavouriteEntity

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(fav: FavouriteEntity)

    @Query("SELECT * FROM favourites")
    fun getAll(): List<FavouriteEntity>

    @Query("SELECT * FROM favourites WHERE id = :id")
    suspend fun getBy(id: Int): FavouriteEntity

    @Delete()
    fun delete(fav: FavouriteEntity)
}