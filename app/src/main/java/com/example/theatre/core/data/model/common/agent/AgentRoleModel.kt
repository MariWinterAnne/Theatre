package com.example.theatre.core.data.model.common.agent

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent role - модель для получения деталей о роли
 *
 * @property slug - слаг
 * @property name - наименование роли
 *
 */
data class AgentRoleModel(
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("name")
    val name: String = String.EMPTY
)
