package com.example.theatre.features.info.domain.usecases


import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.domain.model.safeCall
import com.example.theatre.core.domain.model.common.agent.Agent
import com.example.theatre.features.info.domain.repository.TheatreRepository

/**
 * Get person use case
 *
 * @property theatreRepository - репозиторий
 * @author Tamerlan Mamukhov
 */

class GetPersonUseCase(private val theatreRepository: TheatreRepository) {
    suspend fun getPerson(): ResultState<List<Agent>> = safeCall { theatreRepository.getPerson() }
    suspend fun getPersonById(id: Int): ResultState<Agent> =
        safeCall { theatreRepository.getPersonById(id) }
}