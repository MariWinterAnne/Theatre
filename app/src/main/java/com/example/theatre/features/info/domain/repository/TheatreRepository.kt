package com.example.theatre.features.info.domain.repository

import com.example.theatre.features.info.domain.model.Theatre

interface TheatreRepository {
    suspend fun getTheatre(): List<Theatre>
}