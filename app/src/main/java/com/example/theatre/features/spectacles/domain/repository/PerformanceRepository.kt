package com.example.theatre.features.spectacles.domain.repository

import com.example.theatre.features.spectacles.data.model.Location
import com.example.theatre.features.spectacles.data.model.Place
import com.example.theatre.features.spectacles.domain.model.Agent
import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.domain.model.Role

interface PerformanceRepository {
    suspend fun getPerformance(): List<Performance>
    suspend fun getPerformanceById(id: Int): Performance
    suspend fun getPlaceById(id: Int): Place
    suspend fun getCityName(slug: String): Location
    suspend fun getAgent(): List<Agent>
    suspend fun getRole(): List<Role>
}