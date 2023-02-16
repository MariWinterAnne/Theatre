package com.example.theatre.core.domain.model.common.performance

import com.example.theatre.core.domain.model.common.agent.Agent
import com.example.theatre.core.domain.model.common.agent.AgentRoleTitle

/**
 * Performance participants - модель для получения списка актеров и их ролей
 *
 * @property role - роль [AgentRole]
 * @property agentModel - участник постановки [Agent]
 *
 * @author Tamerlan Mamukhov
 */

data class PerformanceParticipants(
    val role: AgentRoleTitle?,
    val agentModel: Agent?,
)
