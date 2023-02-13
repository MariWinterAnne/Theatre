package com.example.theatre.features.poster.data.mappers

import com.example.theatre.core.data.mappers.toImage
import com.example.theatre.features.poster.data.api.model.PosterBriefModel
import com.example.theatre.features.poster.data.model.PosterDetailsModel
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.spectacles.data.mappers.toPerformanceDates
import com.example.theatre.features.spectacles.data.mappers.toPerformanceParticipants

fun PosterBriefModel.toPosterBriefItem() = PosterBriefItem(
    id = id,
    image = images?.first()?.toImage(),
    title = title,
    description = description
)

fun PosterDetailsModel.toPosterDetails() = PosterDetails(
    id,
    images = images?.map { it.toImage() },
    title,
    shortTitle = shortTitle,
    description = description,
    tagline = tagline,
    publicationDate = publicationDate,
    price = price,
    ageRestriction = ageRestriction,
    dates = dates?.map { it.toPerformanceDates() },
    participants = participants?.map { it.toPerformanceParticipants() },
    bodyText = bodyText,
    siteUrl = siteUrl
)