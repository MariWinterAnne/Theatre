package com.example.theatre.features.info.data.api

import com.example.theatre.features.info.data.mappers.toAgent
import com.example.theatre.features.info.domain.model.Agent

/**
 * Person api mapper - маппер для списка актеров
 *
 * @author Marianna Sabanchieva
 */

class PersonApiMapper(private val personApi: PersonApi) {
    suspend fun getPersons(): List<Agent> = personApi.getPerson().data.map { it.toAgent() }

    suspend fun getTheatreById(id: Int): Agent = personApi.getPersonById(id).toAgent()
}