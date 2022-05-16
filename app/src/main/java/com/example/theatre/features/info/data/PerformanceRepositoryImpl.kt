package com.example.theatre.features.info.data

import com.example.theatre.features.info.data.mappers.GetTheatreMapper
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.network.net.RetrofitClient

class TheatreRepositoryImpl(
    private val getTheatreMapper: GetTheatreMapper
) : TheatreRepository {
    override suspend fun getTheatre(): List<Theatre> =
        RetrofitClient.retrofit.getPlaces().results.map{getTheatreMapper.getTheatre(it)}
}