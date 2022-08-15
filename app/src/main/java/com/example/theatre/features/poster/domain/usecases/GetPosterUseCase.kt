package com.example.theatre.features.poster.domain.usecases

import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.domain.repository.PosterRepository

/**
 * Use Case для получения афиш
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
class GetPosterUseCase(private val posterRepository: PosterRepository) {
   suspend fun getPosters(): List<PosterBriefItem> = posterRepository.getPostersBrief()

   suspend fun getPosterDetailsById(id: Int): PosterDetails = posterRepository.getPosterDetailsById(id)
}