package com.example.theatre.features.info.data

import com.example.theatre.features.info.data.mappers.GetPersonMapper
import com.example.theatre.features.info.data.mappers.GetTheatreMapper
import com.example.theatre.features.info.data.model.GetAgent
import com.example.theatre.features.info.data.model.TheatrePlace
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.network.net.RetrofitClient

class TheatreRepositoryImpl(
    private val getTheatreMapper: GetTheatreMapper,
    private val getPersonMapper: GetPersonMapper
) : TheatreRepository {
    override suspend fun getTheatre(): List<Theatre> =
        RetrofitClient.retrofit.getPlaces().results.map{getTheatreMapper.getTheatre(it)}

    override suspend fun getTheatreById(id: Int): TheatrePlace =
        RetrofitClient.retrofit.getTheatreById(id = id)


    override suspend fun getPerson(): List<Agent> =
        RetrofitClient.retrofit.getPerson().results.map{getPersonMapper.getPerson(it)}

    override suspend fun getPersonById(id: Int): GetAgent =
        RetrofitClient.retrofit.getPersonById(id = id)
}