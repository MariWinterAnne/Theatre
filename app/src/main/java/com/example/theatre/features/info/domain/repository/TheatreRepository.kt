package com.example.theatre.features.info.domain.repository

import com.example.theatre.features.info.data.model.GetAgent
import com.example.theatre.features.info.data.model.TheatrePlace
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.Theatre

interface TheatreRepository {
    suspend fun getTheatre(): List<Theatre>
    suspend fun getTheatreById(id: Int): TheatrePlace

    suspend fun getPerson(): List<Agent>
    suspend fun getPersonById(id: Int): GetAgent
}