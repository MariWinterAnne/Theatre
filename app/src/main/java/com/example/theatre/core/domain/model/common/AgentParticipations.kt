package com.example.theatre.core.domain.model.common

/**
 * Agent participations - модель для получения ролей, в которых задействован актер
 *
 * @property role - роль [AgentRole]
 * @property agentParticipationsItem - расшифровка роли [AgentParticipationsItem]
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipations(
    val role: AgentRole?,
    val agentParticipationsItem: AgentParticipationsItem?
)
