package com.example.theatre.core.domain.model.common.agent

/**
 * Agent participation title - модель для расшифровки постановок, в которых задействован актер
 *
 * @property title - наименование постановки
 * @property ctype - жанр постановки
 *
 * @author Tamerlan Mamukhov
 */

data class AgentParticipationTitle(
    val title: String?,
    val ctype: String?
)
