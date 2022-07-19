package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent performance participations model - модель для получения данных о постановках,
 * в которых задействован актер
 *
 * @property role - роль в постановке [AgentRoleNameModel]
 * @property item - данные о постановке [AgentPerformanceParticipationNameModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentPerformanceParticipationsModel(
    @SerializedName("role")
    val role: AgentRoleNameModel? = AgentRoleNameModel(),
    @SerializedName("item")
    val item: AgentPerformanceParticipationNameModel? = AgentPerformanceParticipationNameModel()
)
