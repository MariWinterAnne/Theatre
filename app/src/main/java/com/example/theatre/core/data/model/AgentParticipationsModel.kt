package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent participations - модель для получения ролей, в которых задействован актер
 *
 * @property role - роль [AgentRoleModel]
 * @property agent_participations_item - расшифровка роли [AgentParticipationsItemModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsModel(
    @SerializedName("role")
    val role: AgentRoleModel? = AgentRoleModel(),
    @SerializedName("item")
    val agent_participations_item: AgentParticipationsItemModel? = AgentParticipationsItemModel()
)
