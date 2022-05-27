package com.example.theatre.core.data.model

import com.example.theatre.core.domain.model.Role
import com.google.gson.annotations.SerializedName

/**
 * Agent participations
 *
 * @property role - роль
 * @property agent_participations_item - расшифровка роли
 * @constructor Create empty Agent participations
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipations(
    @SerializedName("role")
    val role: Role? = Role(),
    @SerializedName("item")
    val agent_participations_item: AgentParticipationsItem? = AgentParticipationsItem()
)
