package com.example.theatre.core.domain.model

import com.example.theatre.core.data.model.ModelImages
import com.example.theatre.core.data.model.AgentParticipations

/**
 * Agent
 *
 * @property id - идентификатор
 * @property title - наименование агента
 * @property slug - слаг
 * @property description - описание
 * @property body_text - полное описание
 * @property agent_type - тип агента
 * @property images - картинки объекта
 * @property site_url - адрес события на сайте kudago.com
 * @property participations - список участий агента
 * @constructor Create empty Agent
 *
 * @author Marianna Sabanchieva
 */

data class Agent(
    val id: Int? = null,
    val title: String? = null,
    val slug: String? = null,
    val description: String? = null,
    val body_text: String? = null,
    val agent_type: String? = null,
    val images: ArrayList<ModelImages> = arrayListOf(),
    val site_url: String? = null,
    val participations : ArrayList<AgentParticipations> = arrayListOf()
)
