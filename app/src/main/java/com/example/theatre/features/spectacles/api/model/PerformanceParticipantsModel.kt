package com.example.theatre.features.spectacles.api.model

import com.example.theatre.core.data.model.common.agent.AgentModel
import com.example.theatre.core.data.model.common.agent.AgentRoleModel
import com.google.gson.annotations.SerializedName

/**
 * Performance participants - модель для получения списка актеров и их ролей
 *
 * @property role - роль [AgentRoleModel]
 * @property agentModel - участник постановки [AgentModel]
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceParticipantsModel(
    @SerializedName("role")
    val role: AgentRoleModel? = null,
    @SerializedName("agent")
    val agentModel: AgentModel? = null,
)