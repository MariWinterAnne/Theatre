package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.common.agent.AgentModel
import com.example.theatre.core.data.model.common.agent.AgentParticipationsItemModel
import com.example.theatre.core.data.model.common.agent.AgentParticipationsModel
import com.example.theatre.core.data.model.common.agent.AgentRoleModel
import com.example.theatre.core.domain.model.common.agent.Agent
import com.example.theatre.core.domain.model.common.agent.AgentParticipationTitle
import com.example.theatre.core.domain.model.common.agent.AgentParticipations
import com.example.theatre.core.domain.model.common.agent.AgentRoleTitle
import com.example.theatre.features.spectacles.data.mappers.toPerformancePlace

/**
 * Проводит дополнительные преобразования
 * Например, конвертирует список из data model в список domain model
 *
 * @author Tamerlan Mamukhov
 */

fun AgentRoleModel.toAgentRole() = AgentRoleTitle(
    slug = slug,
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
    item = toAgentParticipationsItem()
)

fun AgentParticipationsItemModel.toAgentParticipationsItem() = AgentParticipationTitle(
    title = title,
    ctype = ctype,
)

fun AgentModel.toListAgentImages() =
    images?.map { it.toImage() }

fun AgentModel.toListAgentParticipations() =
    participations?.map { it.toAgentParticipations() }

fun AgentParticipationsModel.toAgentParticipationsItem() =
    agentParticipationsItem?.toAgentParticipationsItem()

fun AgentParticipationsModel.toAgentRole() =
    role?.toAgentRole()