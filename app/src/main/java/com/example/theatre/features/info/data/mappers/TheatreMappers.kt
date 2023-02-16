package com.example.theatre.features.info.data.mappers

import com.example.theatre.core.data.mappers.toImage
import com.example.theatre.features.info.data.model.theatre.TheatreCoordinatesModel
import com.example.theatre.features.info.data.model.theatre.TheatreLocationModel
import com.example.theatre.features.info.data.model.theatre.TheatreModel
import com.example.theatre.features.info.domain.model.theatre.Theatre
import com.example.theatre.features.info.domain.model.theatre.TheatreCoordinates
import com.example.theatre.features.info.domain.model.theatre.TheatreLocation

/**
 * From data to domain
 */

fun TheatreModel.toTheatreCoordinates() =
    coords?.toTheatreCoordinates()

fun TheatreModel.toListImage() =
    images?.map { it.toImage() }


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
