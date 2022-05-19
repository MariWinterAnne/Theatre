package com.example.theatre.features.spectacles.data.mappers

import com.example.theatre.features.spectacles.data.model.GetPerformance
import com.example.theatre.features.spectacles.domain.model.Performance

interface GetPerformanceMapper {
    fun getPerformance(performance: GetPerformance): Performance
}

class GetPerformanceMapperImpl : GetPerformanceMapper {
    override fun getPerformance(performance: GetPerformance) =
        Performance(
            performance.id,
            performance.publicationDate,
            performance.dates,
            performance.title,
            performance.shortTitle,
            performance.slug,
            performance.place,
            performance.description,
            performance.bodyText,
            performance.location,
            performance.categories,
            performance.tagline,
            performance.ageRestriction,
            performance.price,
            performance.isFree,
            performance.images,
            performance.favoritesCount,
            performance.commentsCount,
            performance.siteUrl,
            performance.tags,
            performance.participants
        )
}