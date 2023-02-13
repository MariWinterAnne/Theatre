package com.example.theatre.features.poster.data.api

import com.example.theatre.features.poster.data.mappers.toPosterBriefItem
import com.example.theatre.features.poster.data.mappers.toPosterDetails
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails

/**
 * Маппер для получения с сети списка афиш кратких
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
class PosterApiMapper(private val posterApi: PosterApi) {
    suspend fun getPosters(): List<PosterBriefItem> =
        posterApi.getPosters().data.map { it.toPosterBriefItem() }

    suspend fun getPosterDetailsById(id: Int): PosterDetails =
        posterApi.getPosterDetailsById(id).toPosterDetails()
}