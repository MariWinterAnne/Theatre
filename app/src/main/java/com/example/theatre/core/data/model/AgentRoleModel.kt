package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent role - модель для получения деталей о роли
 *
 * @property id - идентификатор
 * @property slug - слаг
 * @property name - наименование роли
 *
 * @author Marianna Sabanchieva
 */

data class AgentRoleModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null
)
