package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent model - модель для получения деталей об актере
 *
 * @property id - идентификатор
 * @property title - наименование агента
 * @property slug - слаг
 * @property description - описание
 * @property body_text - полное описание
 * @property agent_type - тип агента
 * @property images - картинки объекта [ModelImages]
 * @property site_url - адрес события на сайте kudago.com
 * @property participations - список участий агента [AgentParticipationsModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("body_text")
    val body_text: String? = null,
    @SerializedName("agent_type")
    val agent_type: String? = null,
    @SerializedName("images")
    val images: ArrayList<ModelImages> = arrayListOf(),
    @SerializedName("site_url")
    val site_url: String? = null,
    @SerializedName("participations")
    val participations: ArrayList<AgentParticipationsModel> = arrayListOf()
)
