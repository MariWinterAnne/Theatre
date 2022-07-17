package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent model - модель для получения деталей об актере
 *
 * @property id - идентификатор
 * @property title - наименование агента
 * @property slug - слаг
 * @property description - описание
 * @property bodyText - полное описание
 * @property agentType - тип агента
 * @property images - картинки объекта [ModelImages]
 * @property siteUrl - адрес события на сайте kudago.com
 * @property participations - список участий агента [AgentParticipationsModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String = String.EMPTY,
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("body_text")
    val bodyText: String = String.EMPTY,
    @SerializedName("agent_type")
    val agentType: String = String.EMPTY,
    @SerializedName("images")
    val images: List<ModelImages> = listOf(),
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY,
    @SerializedName("participations")
    val participations: List<AgentParticipationsModel> = listOf()
)
