package com.example.theatre.features.spectacles.domain.repository

import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.Performance

/**
 * Репозиторий
 *
 * @author Marianna Sabanchieva
 */

interface PerformanceRepository {
    /**
     * Get performance
     *
     * @return - список постановок
     */
    suspend fun getPerformance(): List<Performance>

    /**
     * Get performance by id
     *
     * @param id - идентификатор постановки
     * @return - детали о выбранной постановке
     */
    suspend fun getPerformanceById(id: Int): Performance

    /**
     * Get place by id
     *
     * @param id - идентификатор постановки
     * @return - место проведения выбранной постановки
     */
    suspend fun getPlaceById(id: Int): PerformancePlace

    /**
     * Get city name
     *
     * @param slug
     * @return - город, где проходит постановка
     */
    suspend fun getCityName(slug: String): PerformancePlaceLocation
}