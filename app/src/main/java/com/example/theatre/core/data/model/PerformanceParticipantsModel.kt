package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance participants - модель для получения списка актеров и их ролей
 *
 * @property role - роль [AgentRoleModel]
 * @property agent_model - участник постановки [AgentModel]
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceParticipantsModel(
    @SerializedName("role")
    val role: AgentRoleModel? = AgentRoleModel(),
    @SerializedName("agent")
    val agent_model: AgentModel? = AgentModel(),
)
