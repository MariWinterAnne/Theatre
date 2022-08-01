package com.example.theatre.features.poster.domain.repository

import com.example.theatre.features.poster.domain.model.PosterBriefItem

/**
 * Репозиторий для списка афиш и их детализации
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
interface PosterRepository {
   suspend fun getPostersBrief(): List<PosterBriefItem>
}