package com.example.theatre.features.info.data.mappers

import com.example.theatre.features.info.data.model.AgentModel
import com.example.theatre.features.info.data.model.TheatreModel
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.model.Theatre

fun AgentModel.toAgent() = Agent(
    id,
    title,
    slug,
    description,
    bodyText,
    agentType,
    images,
    siteUrl,
    isStub,
    participations
)

fun TheatreModel.toTheatre() = Theatre(
    id,
    title,
    shortTitle,
    slug,
    address,
    location,
    timetable,
    phone,
    isStub,
    images,
    description,
    bodyText,
    siteUrl,
    foreignUrl,
    coords,
    subway,
    favoritesCount,
    commentsCount,
    isClosed,
    categories,
    tags
)