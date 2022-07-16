package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.AgentModel
import com.example.theatre.core.data.model.AgentParticipationsModel
import com.example.theatre.core.data.model.AgentParticipationsItemModel
import com.example.theatre.core.data.model.AgentRoleModel
import com.example.theatre.core.data.model.ModelImages
import com.example.theatre.core.data.model.PerformanceModel
import com.example.theatre.core.data.model.PerformanceDatesModel
import com.example.theatre.core.data.model.PerformanceParticipantsModel
import com.example.theatre.core.data.model.PerformancePlaceModel
import com.example.theatre.core.data.model.PerformancePlaceCoordinatesModel
import com.example.theatre.core.data.model.PerformancePlaceLocationModel
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

/**
 * To performance - конвертирует data model в domain model
 *
 * @author Marianna Sabanchieva
 */

fun PerformanceModel.toPerformance() = Performance(
    id = id,
    publication_date = publication_date,
    dates = dates.map { it.toPerformanceDates() } as ArrayList<PerformanceDates>,
    title = title,
    short_title = short_title,
    slug = slug,
    place = place?.toPerformancePlace(),
    description = description,
    body_text = body_text,
    location = location?.toPerformancePlaceLocation(),
    categories = categories,
    tagline = tagline,
    age_restriction = age_restriction,
    price = price,
    is_free = is_free,
    images = images.map { it.toImages() } as ArrayList<Images>,
    favorites_count = favorites_count,
    comments_count = comments_count,
    site_url = site_url,
    tags = tags,
    participants = participants.map { it.toPerformanceParticipants() } as ArrayList<PerformanceParticipants>
)

fun PerformanceDatesModel.toPerformanceDates() = PerformanceDates(
    start_date = start_date,
    start_time = start_time,
    start = start,
    end_date = end_date,
    end_time = end_time,
    end = end,
    is_continuous = is_continuous,
    is_endless = is_endless,
    is_startless = is_startless
)

fun PerformancePlaceModel.toPerformancePlace() = PerformancePlace(
    id = id,
    title = title,
    short_title = short_title,
    slug = slug,
    description = description,
    address = address,
    phone = phone,
    subway = subway,
    location = location,
    site_url = site_url,
    foreign_url = foreign_url,
    is_closed = is_closed,
    performance_place_coordinates = performance_place_coordinates?.toPerformancePlaceCoordinates()
)

fun PerformancePlaceLocationModel.toPerformancePlaceLocation() = PerformancePlaceLocation(
    slug = slug,
    name = name,
    timezone = timezone,
    performance_place_coordinates = performance_place_coordinates?.toPerformancePlaceCoordinates(),
    language = language
)

fun PerformancePlaceCoordinatesModel.toPerformancePlaceCoordinates() = PerformancePlaceCoordinates(
    lat = lat,
    lon = lon
)

fun ModelImages.toImages() = Images(
    image = image
)

fun PerformanceParticipantsModel.toPerformanceParticipants() = PerformanceParticipants(
    role = role?.toAgentRole(),
    agent_model = agent_model?.toAgent()
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
    body_text = body_text,
    agent_type = agent_type,
    images = images.map { it.toImages() } as ArrayList<Images>,
    site_url = site_url,
    participations = participations.map { it.toAgentParticipations() } as ArrayList<AgentParticipations>
)

fun AgentParticipationsModel.toAgentParticipations() = AgentParticipations(
    role = role?.toAgentRole(),
    agent_participations_item = agent_participations_item?.toAgentParticipationsItem()
)

fun AgentParticipationsItemModel.toAgentParticipationsItem() = AgentParticipationsItem(
    id = id,
    title = title,
    description = description,
    item_url = item_url,
    ctype = ctype,
    performance_place = performance_place?.toPerformancePlace(),
    first_image = first_image?.toImages(),
    age_restriction = age_restriction
)