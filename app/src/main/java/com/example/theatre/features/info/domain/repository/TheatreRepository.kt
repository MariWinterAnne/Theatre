package com.example.theatre.features.info.domain.repository

import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.features.info.domain.model.Theatre

/**
 * Репозиторий для списка постановок и актеров, а также их детализации
 *
 * @author Marianna Sabanchieva
 */

interface TheatreRepository {
    suspend fun getTheatre(): List<Theatre>
    suspend fun getTheatreById(id: Int): Theatre

    /**
     * Get city name
     *
     * @return - город, где проходит постановка по текстовому идентификатору, пример: msk, spb
     */
    suspend fun getCityName(slug: String): TheatreLocation

    suspend fun getPerson(): List<Agent>
    suspend fun getPersonById(id: Int): Agent
}