package com.example.theatre.features.spectacles.data.api

import com.example.theatre.core.domain.model.common.performance.Performance
import com.example.theatre.core.domain.model.common.performance.PerformancePlace
import com.example.theatre.core.domain.model.common.performance.PerformancePlaceLocation
import com.example.theatre.features.spectacles.data.mappers.toPerformance
import com.example.theatre.features.spectacles.data.mappers.toPerformancePlace
import com.example.theatre.features.spectacles.data.mappers.toPerformancePlaceLocation

/**
 * Performance api mapper - маппер для списка постановок
 *
 * @author Tamerlan Mamukhov
 */

class PerformanceApiMapper(private val performanceApi: PerformanceApi) {
    suspend fun getPerformances(): List<Performance> =
        performanceApi.getPerformance().data.map { it.toPerformance() }

    suspend fun getPerformanceById(id: Int): Performance =
        performanceApi.getPerformanceById(id).toPerformance()

    suspend fun getPlaceById(id: Int): PerformancePlace =
        performanceApi.getPlaceById(id).toPerformancePlace()

    suspend fun getCityName(slug: String): PerformancePlaceLocation =
        performanceApi.getCityName(slug).toPerformancePlaceLocation()
}