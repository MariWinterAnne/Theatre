package com.example.theatre.features.info.data.api

import com.example.theatre.features.info.data.mappers.toTheatre
import com.example.theatre.features.info.data.mappers.toTheatreLocation
import com.example.theatre.features.info.domain.model.theatre.Theatre
import com.example.theatre.features.info.domain.model.theatre.TheatreLocation

/**
 * Theatre api mapper - маппер для списка театров
 *
 * @author Tamerlan Mamukhov
 */

class TheatreApiMapper(private val theatreApi: TheatreApi) {
    suspend fun getTheatres(): List<Theatre> =
        theatreApi.getTheatres().data.map { it.toTheatre() }

    suspend fun getTheatreById(id: Int): Theatre = theatreApi.getTheatreById(id).toTheatre()

    suspend fun getCityName(slug: String): TheatreLocation =
        theatreApi.getCityName(slug).toTheatreLocation()
}