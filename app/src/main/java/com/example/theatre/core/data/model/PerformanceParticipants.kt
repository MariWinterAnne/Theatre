package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance participants
 *
 * @property role - роль
 * @property agent_model - участник постановки
 * @constructor Create empty Performance participants
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceParticipants(
    @SerializedName("role")
    val role: AgentRole? = AgentRole(),
    @SerializedName("agent")
    val agent_model: AgentModel? = AgentModel(),
)
