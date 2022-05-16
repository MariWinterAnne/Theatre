package com.example.theatre.features.info.data.mappers

import com.example.theatre.features.info.data.model.GetTheatre
import com.example.theatre.features.info.domain.model.Theatre

interface GetTheatreMapper {
    fun getTheatre(theatre: GetTheatre): Theatre
}

class GetTheatreMapperImpl : GetTheatreMapper {
    override fun getTheatre(theatre: GetTheatre) =
        Theatre(
            theatre.id,
            theatre.title,
            theatre.shortTitle,
            theatre.slug,
            theatre.address,
            theatre.location,
            theatre.timetable,
            theatre.phone,
            theatre.isStub,
            theatre.images,
            theatre.description,
            theatre.bodyText,
            theatre.siteUrl,
            theatre.foreignUrl,
            theatre.coords,
            theatre.subway,
            theatre.favoritesCount,
            theatre.commentsCount,
            theatre.isClosed,
            theatre.categories,
            theatre.tags
        )
}