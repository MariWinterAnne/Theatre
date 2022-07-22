package com.example.theatre.features.info.domain.usecases

import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.repository.TheatreRepository

/**
 * Get person use case
 *
 * @property theatreRepository - репозиторий
 * @author Marianna Sabanchieva
 */

class GetPersonUseCase(private val theatreRepository: TheatreRepository) {
    suspend fun getPerson(): List<Agent> = theatreRepository.getPerson()
    suspend fun getPersonById(id: Int): Agent = theatreRepository.getPersonById(id)
}