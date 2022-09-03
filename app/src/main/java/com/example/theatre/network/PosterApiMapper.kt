package com.example.theatre.network

import com.example.theatre.core.data.mappers.toPosterBriefItem
import com.example.theatre.core.data.mappers.toPosterDetails
import com.example.theatre.core.network.BaseApiMapper
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.network.net.PosterApi

/**
 * Маппер для получения с сети списка афиш кратких?
 *
 * @author Tamerlan Mamukhov on 2022-08-03
 */
class PosterApiMapper(private val posterApi: PosterApi) : BaseApiMapper() {
    suspend fun getPosters(): List<PosterBriefItem> =
        posterApi.getPosters().results.map { it.toPosterBriefItem() }

    suspend fun getPosterDetailsById(id: Int): PosterDetails =
        posterApi.getPosterDetailsById(id).toPosterDetails()
}