package com.example.theatre.features.info.domain.model

/**
 * Agent participation title - модель для расшифровки постановок, в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование постановки
 * @property ctype - жанр постановки
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationTitle(
    val id: Int?,
    val title: String?,
    val ctype: String?
)
