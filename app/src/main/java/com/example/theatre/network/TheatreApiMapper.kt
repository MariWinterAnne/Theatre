package com.example.theatre.network

import com.example.theatre.core.network.BaseApiMapper
import com.example.theatre.features.info.data.mappers.toTheatre
import com.example.theatre.features.info.data.mappers.toTheatreLocation
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.network.net.TheatreApi

/**
 * Theatre api mapper - маппер для списка театров
 *
 * @author Marianna Sabanchieva
 */

class TheatreApiMapper(private val theatreApi: TheatreApi) : BaseApiMapper() {
    suspend fun getTheatres(): List<Theatre> =
        theatreApi.getTheatres().results.map { it.toTheatre() }

    suspend fun getTheatreById(id: Int): Theatre = theatreApi.getTheatreById(id).toTheatre()

    suspend fun getCityName(slug: String): TheatreLocation = theatreApi.getCityName(slug).toTheatreLocation()
}