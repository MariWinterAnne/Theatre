package com.example.theatre.features.info.domain.usecases

import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.repository.TheatreRepository

/**
 * Get theatre use case
 *
 * @property theatreRepository - репозиторий
 * @author Marianna Sabanchieva
 */

class GetTheatreUseCase (private val theatreRepository: TheatreRepository) {
    suspend fun getTheatre(): List<Theatre> = theatreRepository.getTheatre()
    suspend fun getTheatreById(id: Int): Theatre = theatreRepository.getTheatreById(id)
    suspend fun getCityName(slug: String): TheatreLocation = theatreRepository.getCityName(slug)
}