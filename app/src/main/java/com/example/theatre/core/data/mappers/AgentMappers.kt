package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.common.agent.AgentModel
import com.example.theatre.core.data.model.common.agent.AgentParticipationsItemModel
import com.example.theatre.core.data.model.common.agent.AgentParticipationsModel
import com.example.theatre.core.data.model.common.agent.AgentRoleModel
import com.example.theatre.core.domain.models.Agent
import com.example.theatre.core.domain.models.AgentParticipations
import com.example.theatre.core.domain.models.AgentParticipationsItem
import com.example.theatre.core.domain.models.AgentRole
import com.example.theatre.features.spectacles.data.mappers.toPerformancePlace

/**
 * Проводит дополнительные преобразования
 * Например, конвертирует список из data model в список domain model
 *
 * @author Marianna Sabanchieva
 */


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

fun AgentModel.toListAgentImages() =
    images?.map { it.toImages() }

fun AgentModel.toListAgentParticipations() =
    participations?.map { it.toAgentParticipations() }

fun AgentParticipationsModel.toAgentParticipationsItem() =
    agentParticipationsItem?.toAgentParticipationsItem()

fun AgentParticipationsModel.toAgentRole() =
    role?.toAgentRole()

fun AgentParticipationsItemModel.toImages() =
    firstImage?.toImages()

fun AgentParticipationsItemModel.toPerformancePlace() =
    performancePlace?.toPerformancePlace()