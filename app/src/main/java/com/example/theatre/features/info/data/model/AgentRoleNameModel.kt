package com.example.theatre.features.info.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent role name model - модель для расшифровки роли
 *
 * @property slug - слаг роли
 * @property name - название роли
 *
 * @author Marianna Sabanchieva
 */

data class AgentRoleNameModel(
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("name")
    val name: String = String.EMPTY
)
