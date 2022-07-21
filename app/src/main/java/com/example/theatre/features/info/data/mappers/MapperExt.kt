package com.example.theatre.features.info.data.mappers

import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.features.info.data.model.AgentPerformanceParticipationNameModel
import com.example.theatre.features.info.data.model.AgentPerformanceParticipationsModel
import com.example.theatre.features.info.data.model.AgentRoleNameModel
import com.example.theatre.features.info.data.model.ImagesModel
import com.example.theatre.features.info.data.model.TheatreCoordinatesModel
import com.example.theatre.features.info.data.model.TheatreLocationModel
import com.example.theatre.features.info.data.model.TheatreModel
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.AgentParticipationTitle
import com.example.theatre.features.info.domain.model.AgentPerformanceParticipations
import com.example.theatre.features.info.domain.model.AgentRoleTitle
import com.example.theatre.features.info.domain.model.Images
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.model.TheatreCoordinates
import com.example.theatre.features.info.domain.model.TheatreLocation

/**
 * To agent & theatre - конвертирует data model в domain model
 *
 * @author Marianna Sabanchieva
 */

fun AgentModel.toAgent() = Agent(
    id = id,
    title = title,
    slug = slug,
    description = description,
    bodyText = bodyText,
    agentType = agentType,
    images = toListImage(),
    siteUrl = siteUrl,
    participations = toListAgentPerformanceParticipationsModel()
)

fun AgentPerformanceParticipationsModel.toAgentPerformanceParticipations() = AgentPerformanceParticipations(
    role = toAgentRoleTitle(),
    item = toAgentParticipationTitle()
)

fun AgentPerformanceParticipationNameModel.toAgentParticipationTitle() = AgentParticipationTitle(
    id = id,
    title = title,
    ctype = ctype
)

fun AgentRoleNameModel.toAgentRoleTitle() = AgentRoleTitle(
    slug = slug
)

fun ImagesModel.toImages() = Images(
    imageURL = imageURL
)

fun TheatreModel.toTheatre() = Theatre(
    id = id,
    title = title,
    shortTitle = shortTitle,
    slug = slug,
    address = address,
    location = location,
    timetable = timetable,
    phone = phone,
    isStub = isStub,
    images = toListImage(),
    description = description,
    bodyText = bodyText,
    siteUrl = siteUrl,
    foreignUrl = foreignUrl,
    coords = toTheatreCoordinates(),
    subway = subway,
    favoritesCount = favoritesCount,
    commentsCount = commentsCount,
    isClosed = isClosed,
    categories = categories,
    tags = tags
)

fun TheatreCoordinatesModel.toTheatreCoordinates() = TheatreCoordinates(
    lat = lat,
    lon = lon
)

fun TheatreLocationModel.toTheatreLocation() = TheatreLocation(
    slug = slug,
    name = name,
    timezone = timezone,
    language = language
)