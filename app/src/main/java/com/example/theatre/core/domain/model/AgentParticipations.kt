package com.example.theatre.core.domain.model

/**
 * Agent participations - модель для получения ролей, в которых задействован актер
 *
 * @property role - роль [AgentRole]
 * @property agent_participations_item - расшифровка роли [AgentParticipationsItem]
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipations(
    val role: AgentRole?,
    val agent_participations_item: AgentParticipationsItem?
)
