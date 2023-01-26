package com.example.theatre.features.spectacles.data

import com.example.theatre.core.domain.models.Performance
import com.example.theatre.core.domain.models.PerformancePlace
import com.example.theatre.core.domain.models.PerformancePlaceLocation
import com.example.theatre.features.spectacles.api.PerformanceApiMapper
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

/**
 * Реализация функций репозитория
 *
 * @property dispatcher
 * @property performanceApiMapper
 *
 * @author Marianna Sabanchieva
 */

class PerformanceRepositoryImpl(
    private val performanceApiMapper: PerformanceApiMapper
) : PerformanceRepository {
    override suspend fun getPerformances(): List<Performance> = performanceApiMapper.getPerformances()
    override suspend fun getPerformanceById(id: Int): Performance = performanceApiMapper.getPerformanceById(id)

    override suspend fun getPlace(id: Int): PerformancePlace = performanceApiMapper.getPlaceById(id)
    override suspend fun getCityName(slug: String): PerformancePlaceLocation = performanceApiMapper.getCityName(slug)
}