package com.example.theatre.features.spectacles.domain.repository

import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.PerformancePlace

/**
 * Репозиторий для списка постановок и их детализации
 *
 * @author Marianna Sabanchieva
 */

interface PerformanceRepository {
    suspend fun getPerformances(): List<Performance>
    suspend fun getPerformanceById(id: Int): Performance

    /**
     * Get place by id
     *
     * @return - место проведения выбранной постановки по идентификатору
     */
    suspend fun getPlace(id: Int): PerformancePlace

    /**
     * Get city name
     *
     * @return - город, где проходит постановка по текстовому идентификатору, пример: msk, spb
     */
    suspend fun getCityName(slug: String): PerformancePlaceLocation
}