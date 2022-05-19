package com.example.theatre.features.spectacles.data.mappers

import com.example.theatre.features.spectacles.data.model.GetAgent
import com.example.theatre.features.spectacles.domain.model.Agent

interface GetAgentMapper {
    fun getAgent(agent: GetAgent): Agent
}

class GetAgentMapperImpl : GetAgentMapper {
    override fun getAgent(agent: GetAgent) =
        Agent(
            agent.id,
            agent.title,
            agent.slug,
            agent.description,
            agent.bodyText,
            agent.agentType,
            agent.images,
            agent.siteUrl,
            agent.participations
        )
}