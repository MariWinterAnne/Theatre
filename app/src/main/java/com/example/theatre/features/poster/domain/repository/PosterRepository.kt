package com.example.theatre.features.poster.domain.repository

import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails

/**
 * Репозиторий для списка афиш и их детализации
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
interface PosterRepository {
   suspend fun getPostersBrief(): List<PosterBriefItem>

   suspend fun getPosterDetailsById(id: Int): PosterDetails
}