package com.example.theatre.features.info.data

import com.example.theatre.features.info.data.api.PersonApiMapper
import com.example.theatre.features.info.data.api.TheatreApiMapper
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.features.info.domain.repository.TheatreRepository

/**
 * Реализация функций репозитория
 *
 * @property dispatcher
 * @property theatreApiMapper
 * @property personApiMapper
 *
 * @author Marianna Sabanchieva
 */

class TheatreRepositoryImpl(
    private val theatreApiMapper: TheatreApiMapper,
    private val personApiMapper: PersonApiMapper
) : TheatreRepository {
    override suspend fun getTheatre(): List<Theatre> = theatreApiMapper.getTheatres()
    override suspend fun getTheatreById(id: Int): Theatre = theatreApiMapper.getTheatreById(id)

    override suspend fun getCityName(slug: String): TheatreLocation = theatreApiMapper.getCityName(slug)

    override suspend fun getPerson(): List<Agent> = personApiMapper.getPersons()
    override suspend fun getPersonById(id: Int): Agent = personApiMapper.getTheatreById(id)
}