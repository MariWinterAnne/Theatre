package com.example.theatre.features.info.domain.usecases

import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.repository.TheatreRepository

interface GetTheatreUseCase{
    suspend fun getTheatre(): List<Theatre>
}

class GetTheatreUseCaseImpl(
    private val theatreRepository: TheatreRepository
): GetTheatreUseCase {
    override suspend fun getTheatre(): List<Theatre> = theatreRepository.getTheatre()
}