package com.example.theatre.network

import com.example.theatre.core.data.mappers.toPerformance
import com.example.theatre.core.data.mappers.toPerformancePlace
import com.example.theatre.core.data.mappers.toPerformancePlaceLocation
import com.example.theatre.core.network.BaseApiMapper
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.PerformancePlace
import com.example.theatre.network.net.PerformanceApi

/**
 * Performance api mapper - маппер для списка постановок
 *
 * @author Marianna Sabanchieva
 */

class PerformanceApiMapper(private val performanceApi: PerformanceApi) : BaseApiMapper() {
    suspend fun getPerformances(): List<Performance> =
        performanceApi.getPerformance().results.map { it.toPerformance() }

    suspend fun getPerformanceById(id: Int): Performance =
        performanceApi.getPerformanceById(id).toPerformance()

    suspend fun getPlaceById(id: Int): PerformancePlace =
        performanceApi.getPlaceById(id).toPerformancePlace()

    suspend fun getCityName(slug: String): PerformancePlaceLocation =
        performanceApi.getCityName(slug).toPerformancePlaceLocation()
}