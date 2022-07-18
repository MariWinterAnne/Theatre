package com.example.theatre.network

import com.example.theatre.core.network.BaseApiMapper
import com.example.theatre.features.info.data.mappers.toAgent
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.network.net.PersonApi

/**
 * Person api mapper - маппер для списка актеров
 *
 * @author Marianna Sabanchieva
 */

class PersonApiMapper(private val personApi: PersonApi) : BaseApiMapper() {
    suspend fun getPersons(): List<Agent> = personApi.getPerson().results.map { it.toAgent() }

    suspend fun getTheatreById(id: Int): Agent = personApi.getPersonById(id).toAgent()
}