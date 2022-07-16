package com.example.theatre.core.domain.model

/**
 * Performance participants - модель для получения списка актеров и их ролей
 *
 * @property role - роль [AgentRole]
 * @property agentModel - участник постановки [Agent]
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceParticipants(
    val role: AgentRole?,
    val agentModel: Agent?,
)
