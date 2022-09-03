package com.example.theatre.features.poster.data

import com.example.theatre.features.poster.data.api.PosterApiMapper
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.domain.repository.PosterRepository

class PosterRepositoryImpl(
    private val posterApiMapper: PosterApiMapper
) : PosterRepository{
    override suspend fun getPostersBrief(): List<PosterBriefItem> = posterApiMapper.getPosters()
    override suspend fun getPosterDetailsById(id: Int): PosterDetails = posterApiMapper.getPosterDetailsById(id)
}