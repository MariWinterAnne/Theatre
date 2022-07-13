package com.example.theatre.features.spectacles.domain.usecases

import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.PerformancePlace
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

/**
 * Get performance use case
 *
 * @property performanceRepository - репозиторий
 *
 * @author Marianna Sabanchieva
 */

class GetPerformanceUseCase(private val performanceRepository: PerformanceRepository) {
    suspend fun getPerformance(): List<Performance> = performanceRepository.getPerformances()
    suspend fun getPerformanceById(id: Int): Performance = performanceRepository.getPerformanceById(id)

    suspend fun getPlace(id: Int): PerformancePlace = performanceRepository.getPlace(id)
    suspend fun getCityName(slug: String): PerformancePlaceLocation = performanceRepository.getCityName(slug)
}