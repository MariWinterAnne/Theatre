package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent role
 *
 * @property id - идентификатор
 * @property slug - слаг
 * @property name - наименование роли
 * @constructor Create empty Agent role
 *
 * @author Marianna Sabanchieva
 */

data class AgentRole(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null
)
