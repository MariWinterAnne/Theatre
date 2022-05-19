package com.example.theatre.features.spectacles.domain.usecases

import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.domain.repository.PerformanceRepository

interface GetPerformanceUseCase{
    suspend fun getPerformance(): List<Performance>
}

class GetPerformanceUseCaseImpl(
    private val performanceRepository: PerformanceRepository
): GetPerformanceUseCase {
    override suspend fun getPerformance(): List<Performance> = performanceRepository.getPerformance()
}