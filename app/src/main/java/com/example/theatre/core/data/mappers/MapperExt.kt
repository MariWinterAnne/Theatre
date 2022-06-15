package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.AgentModel
import com.example.theatre.core.data.model.AgentRole
import com.example.theatre.core.data.model.PerformanceModel
import com.example.theatre.core.domain.model.Agent
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.Role

/**
 * To performance
 *
 * converts data model to domain model
 *
 * @author Marianna Sabanchieva
 */

fun PerformanceModel.toPerformance() = Performance(
    id,
    publication_date,
    dates,
    title,
    short_title,
    slug,
    place,
    description,
    body_text,
    location,
    categories,
    tagline,
    age_restriction,
    price,
    is_free,
    images,
    favorites_count,
    comments_count,
    site_url,
    tags,
    participants
)

fun AgentModel.toAgent() = Agent(
    id,
    title,
    slug,
    description,
    body_text,
    agent_type,
    images,
    site_url,
    participations
)

fun AgentRole.toRole() = Role(
    id,
    name
)