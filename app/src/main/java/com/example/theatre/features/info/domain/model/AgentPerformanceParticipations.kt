package com.example.theatre.features.info.domain.model

/**
 * Agent performance participations - модель для получения данных о постановках,
 * в которых задействован актер
 *
 * @property role - роль в постановке [AgentRoleTitle]
 * @property item - данные о постановке [AgentParticipationTitle]
 *
 * @author Marianna Sabanchieva
 */

data class AgentPerformanceParticipations(
    val role: AgentRoleTitle?,
    val item: AgentParticipationTitle?
)
