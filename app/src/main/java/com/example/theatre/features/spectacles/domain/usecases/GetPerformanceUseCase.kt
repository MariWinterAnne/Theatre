package com.example.theatre.features.spectacles.domain.usecases

import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

/**
 * Get performance use case
 *
 * @property performanceRepository - репозиторий
 *
 * @author Marianna Sabanchieva
 */

class GetPerformanceUseCase(private val performanceRepository: PerformanceRepository) {
    suspend fun getPerformance(): List<Performance> = performanceRepository.getPerformance()
    suspend fun getPerformanceById(id: Int): Performance = performanceRepository.getPerformanceById(id)

    suspend fun getPlaceById(id: Int): PerformancePlace = performanceRepository.getPlaceById(id)
    suspend fun getCityName(slug: String): PerformancePlaceLocation = performanceRepository.getCityName(slug)
}