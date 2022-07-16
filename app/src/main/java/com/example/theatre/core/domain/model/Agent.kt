package com.example.theatre.core.domain.model

/**
 * Agent - модель для получения деталей об актере
 *
 * @property id - идентификатор
 * @property title - наименование агента
 * @property slug - слаг
 * @property description - описание
 * @property body_text - полное описание
 * @property agent_type - тип агента
 * @property images - картинки объекта
 * @property site_url - адрес события на сайте kudago.com
 * @property participations - список участий агента [AgentParticipations]
 *
 * @author Marianna Sabanchieva
 */

data class Agent(
    val id: Int?,
    val title: String?,
    val slug: String?,
    val description: String?,
    val body_text: String?,
    val agent_type: String?,
    val images: ArrayList<Images>,
    val site_url: String?,
    val participations : ArrayList<AgentParticipations>
)
