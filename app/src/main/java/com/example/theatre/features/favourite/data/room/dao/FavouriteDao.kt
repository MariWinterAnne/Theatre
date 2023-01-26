package com.example.theatre.features.favourite.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.theatre.features.favourite.data.room.entity.FavouriteEntity

@Dao
interface FavouriteDao {
    @Insert
    suspend fun save(fav: FavouriteEntity)

    @Query("SELECT * FROM favourites")
    fun getAll(): LiveData<List<FavouriteEntity>>

    @Query("SELECT * FROM favourites WHERE id = :id")
    suspend fun getBy(id: Int): FavouriteEntity

    @Delete()
    fun delete(fav: FavouriteEntity)
}