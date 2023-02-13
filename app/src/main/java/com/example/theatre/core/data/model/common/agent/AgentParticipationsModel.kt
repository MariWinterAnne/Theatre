package com.example.theatre.core.data.model.common.agent

import com.google.gson.annotations.SerializedName

/**
 * Agent participations - модель для получения ролей, в которых задействован актер
 *
 * @property role - роль [AgentRoleModel]
 * @property agentParticipationsItem - расшифровка роли [AgentParticipationsItemModel]
 *
 * @author Tamerlan Mamukhov
 */

data class AgentParticipationsModel(
    @SerializedName("role")
    val role: AgentRoleModel? = null,
    @SerializedName("item")
    val agentParticipationsItem: AgentParticipationsItemModel? = null
)
