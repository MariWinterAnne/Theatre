package com.example.theatre.core.domain.model.common.agent

/**
 * Agent performance participations - модель для получения данных о постановках,
 * в которых задействован актер
 *
 * @property role - роль в постановке [AgentRoleTitle]
 * @property item - данные о постановке [AgentParticipationTitle]
 *
 * @author Tamerlan Mamukhov
 */

data class AgentParticipations(
    val role: AgentRoleTitle?,
    val item: AgentParticipationTitle?
)
