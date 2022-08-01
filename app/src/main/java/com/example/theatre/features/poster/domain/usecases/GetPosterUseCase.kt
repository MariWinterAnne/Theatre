package com.example.theatre.features.poster.domain.usecases

import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.repository.PosterRepository
import com.example.theatre.features.poster.presentation.adapters.PosterBriefItemAdapter

/**
 * Use Case для получения афиш
 * TODO: пока в разработке
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
class GetPosterUseCase(private val posterRepository: PosterRepository) {
   suspend fun getPosters(): List<PosterBriefItem> = posterRepository.getPostersBrief()
}