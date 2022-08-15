package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.*
import com.example.theatre.core.domain.model.Agent
import com.example.theatre.core.domain.model.AgentParticipations
import com.example.theatre.core.domain.model.AgentParticipationsItem
import com.example.theatre.core.domain.model.AgentRole
import com.example.theatre.core.domain.model.Images
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformanceDates
import com.example.theatre.core.domain.model.PerformanceParticipants
import com.example.theatre.core.domain.model.PerformancePlace
import com.example.theatre.core.domain.model.PerformancePlaceCoordinates
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.features.poster.data.model.PosterDetailsModel
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails

/**
 * Конвертирует data model в domain model
 *
 * @author Marianna Sabanchieva
 */

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

fun PerformancePlaceCoordinatesModel.toPerformancePlaceCoordinates() = PerformancePlaceCoordinates(
    lat = lat,
    lon = lon
)

fun ModelImages.toImages() = Images(
    imageURL = imageURL
)

fun PerformanceParticipantsModel.toPerformanceParticipants() = PerformanceParticipants(
    role = toAgentRole(),
    agentModel = toAgent()
)

fun AgentRoleModel.toAgentRole() = AgentRole(
    id = id,
    slug = slug,
    name = name
)

fun AgentModel.toAgent() = Agent(
    id = id,
    title = title,
    slug = slug,
    description = description,
    bodyText = bodyText,
    agentType = agentType,
    images = toListAgentImages(),
    siteUrl = siteUrl,
    participations = toListAgentParticipations()
)

fun AgentParticipationsModel.toAgentParticipations() = AgentParticipations(
    role = toAgentRole(),
    agentParticipationsItem = toAgentParticipationsItem()
)

fun AgentParticipationsItemModel.toAgentParticipationsItem() = AgentParticipationsItem(
    id = id,
    title = title,
    description = description,
    itemUrl = itemUrl,
    ctype = ctype,
    performancePlace = toPerformancePlace(),
    firstImage = toImages(),
    ageRestriction = ageRestriction
)

// TODO: афиши краткие и подробные
fun PosterBriefModel.toPosterBriefItem() = PosterBriefItem(
    id = id,
    image = images?.first()?.toImages(),
    title = title,
    description = description
)

fun PosterDetailsModel.toPosterDetails() = PosterDetails(
    id, images, title, description, publicationDate
)