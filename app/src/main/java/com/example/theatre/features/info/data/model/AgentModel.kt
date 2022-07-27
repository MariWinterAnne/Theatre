package com.example.theatre.features.info.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent model - модель для получения деталей об актере
 *
 * @property id - идентификатор
 * @property title - название
 * @property slug - слаг
 * @property description - описание
 * @property bodyText - полное описание
 * @property agentType - тип агента
 * @property images - картинки объекта [ImagesModel]
 * @property siteUrl - адрес события на сайте kudago.com
 * @property participations - список участий агента [AgentPerformanceParticipationsModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("body_text")
    val bodyText: String = String.EMPTY,
    @SerializedName("agent_type")
    val agentType: String = String.EMPTY,
    @SerializedName("images")
    val images: List<ImagesModel>?,
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY,
    @SerializedName("participations")
    val participations: List<AgentPerformanceParticipationsModel>?
)
