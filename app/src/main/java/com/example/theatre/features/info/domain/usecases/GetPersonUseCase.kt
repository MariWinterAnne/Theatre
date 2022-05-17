package com.example.theatre.features.info.domain.usecases

import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.repository.TheatreRepository

interface GetPersonUseCase{
    suspend fun getPerson(): List<Agent>
}

class GetPersonUseCaseImpl(
    private val theatreRepository: TheatreRepository
): GetPersonUseCase {
    override suspend fun getPerson(): List<Agent> = theatreRepository.getPerson()
}