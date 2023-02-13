package com.example.theatre.features.spectacles.domain.usecases

import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.domain.model.common.performance.Performance
import com.example.theatre.core.domain.model.common.performance.PerformancePlace
import com.example.theatre.core.domain.model.common.performance.PerformancePlaceLocation
import com.example.theatre.core.domain.model.safeCall
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

/**
 * Get performance use case
 *
 * @property performanceRepository - репозиторий
 *
 * @author Tamerlan Mamukhov
 */

class GetPerformanceUseCase(private val performanceRepository: PerformanceRepository) {
    suspend fun getPerformance(): ResultState<List<Performance>> =
        safeCall { performanceRepository.getPerformances() }

    suspend fun getPerformanceById(id: Int): ResultState<Performance> =
        safeCall { performanceRepository.getPerformanceById(id) }

    suspend fun getPlace(id: Int): ResultState<PerformancePlace> =
        safeCall { performanceRepository.getPlace(id) }

    suspend fun getCityName(slug: String): ResultState<PerformancePlaceLocation> =
        safeCall { performanceRepository.getCityName(slug) }
}