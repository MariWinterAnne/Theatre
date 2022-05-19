package com.example.theatre.features.info.data

import com.example.theatre.features.info.data.mappers.toAgent
import com.example.theatre.features.info.data.mappers.toTheatre
import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.features.info.data.model.TheatrePlace
import com.example.theatre.features.info.data.network.TheatreApiMapper
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.repository.TheatreRepository
import com.example.theatre.features.info.data.network.net.RetrofitClient

class TheatreRepositoryImpl(
    val apiMapper: TheatreApiMapper
) : TheatreRepository {
    override suspend fun getTheatre(): List<Theatre> =
        RetrofitClient.retrofit.getPlaces().results.map { it.toTheatre() }

    override suspend fun getTheatreById(id: Int): TheatrePlace =
        RetrofitClient.retrofit.getTheatreById(id = id)

    override suspend fun getPerson(): List<Agent> =
        RetrofitClient.retrofit.getPerson().results.map { it.toAgent() }

    override suspend fun getPersonById(id: Int): AgentModel =
        RetrofitClient.retrofit.getPersonById(id = id)
}