package com.example.theatre.features.poster.domain.usecases

import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.domain.model.safeCall
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.domain.repository.PosterRepository

/**
 * Use Case для получения афиш
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
class GetPosterUseCase(private val posterRepository: PosterRepository) {
    suspend fun getPosters(): ResultState<List<PosterBriefItem>> =
        safeCall { posterRepository.getPostersBrief() }

    suspend fun getPosterDetailsById(id: Int): ResultState<PosterDetails> =
        safeCall { posterRepository.getPosterDetailsById(id) }
}