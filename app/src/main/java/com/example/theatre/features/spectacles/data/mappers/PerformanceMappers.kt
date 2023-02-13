package com.example.theatre.features.spectacles.data.mappers

import com.example.theatre.core.data.mappers.toAgent
import com.example.theatre.core.data.mappers.toAgentRole
import com.example.theatre.core.data.mappers.toImage
import com.example.theatre.core.domain.model.common.performance.Performance
import com.example.theatre.core.domain.model.common.performance.PerformanceDates
import com.example.theatre.core.domain.model.common.performance.PerformanceParticipants
import com.example.theatre.core.domain.model.common.performance.PerformancePlace
import com.example.theatre.core.domain.model.common.performance.PerformancePlaceCoordinates
import com.example.theatre.core.domain.model.common.performance.PerformancePlaceLocation
import com.example.theatre.features.spectacles.data.api.model.PerformanceDatesModel
import com.example.theatre.features.spectacles.data.api.model.PerformanceModel
import com.example.theatre.features.spectacles.data.api.model.PerformanceParticipantsModel
import com.example.theatre.features.spectacles.data.api.model.PerformancePlaceCoordinatesModel
import com.example.theatre.features.spectacles.data.api.model.PerformancePlaceLocationModel
import com.example.theatre.features.spectacles.data.api.model.PerformancePlaceModel

fun PerformanceModel.toPerformancePlaceLocation() =
    location?.toPerformancePlaceLocation()

fun PerformanceModel.toPerformancePlace() =
    place?.toPerformancePlace()

fun PerformanceModel.toListPerformanceDates() =
    dates?.map { it.toPerformanceDates() }

fun PerformanceModel.toListPerformanceImages() =
    images?.map { it.toImage() }

fun PerformanceModel.toListPerformanceParticipants() =
    participants?.map { it.toPerformanceParticipants() }

fun PerformancePlaceModel.toPerformancePlaceCoordinates() =
    performancePlaceCoordinates?.toPerformancePlaceCoordinates()

fun PerformancePlaceLocationModel.toPerformancePlaceCoordinates() =
    performancePlaceCoordinates?.toPerformancePlaceCoordinates()

fun PerformanceParticipantsModel.toAgent() =
    agentModel?.toAgent()

fun PerformanceParticipantsModel.toAgentRole() =
    role?.toAgentRole()


fun PerformanceParticipantsModel.toPerformanceParticipants() = PerformanceParticipants(
    role = toAgentRole(),
    agentModel = toAgent()
)

fun PerformanceModel.toPerformance() = Performance(
    id = id,
    publicationDate = publicationDate,
    dates = toListPerformanceDates(),
    title = title,
    shortTitle = shortTitle,
    slug = slug,
    place = toPerformancePlace(),
    description = description,
    bodyText = bodyText,
    location = toPerformancePlaceLocation(),
    categories = categories,
    tagline = tagline,
    ageRestriction = ageRestriction,
    price = price,
    isFree = isFree,
    images = toListPerformanceImages(),
    favoritesCount = favoritesCount,
    commentsCount = commentsCount,
    siteUrl = siteUrl,
    tags = tags,
    participants = toListPerformanceParticipants()
)

fun PerformanceDatesModel.toPerformanceDates() = PerformanceDates(
    startDate = startDate,
    startTime = startTime,
    start = start,
    endDate = endDate,
    endTime = endTime,
    end = end,
    isContinuous = isContinuous,
    isEndless = isEndless,
    isStartles = isStartles
)

fun PerformancePlaceModel.toPerformancePlace() = PerformancePlace(
    id = id,
    title = title,
    shortTitle = shortTitle,
    slug = slug,
    description = description,
    address = address,
    phone = phone,
    subway = subway,
    location = location,
    siteUrl = siteUrl,
    foreignUrl = foreignUrl,
    isClosed = isClosed,
    performancePlaceCoordinates = toPerformancePlaceCoordinates()
)

fun PerformancePlaceLocationModel.toPerformancePlaceLocation() = PerformancePlaceLocation(
    slug = slug,
    name = name,
    timezone = timezone,
    performancePlaceCoordinates = toPerformancePlaceCoordinates(),
    language = language
)

fun PerformancePlaceCoordinatesModel.toPerformancePlaceCoordinates() =
    PerformancePlaceCoordinates(
        lat = lat,
        lon = lon
    )
