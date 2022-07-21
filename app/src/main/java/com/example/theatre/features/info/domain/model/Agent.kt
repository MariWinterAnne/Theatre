package com.example.theatre.features.info.domain.model

/**
 * Agent - модель для получения деталей об актере
 *
 * @property id - идентификатор
 * @property title - название
 * @property slug - слаг
 * @property description - описание
 * @property bodyText - полное описание
 * @property agentType - тип агента
 * @property images - картинки объекта [Images]
 * @property siteUrl - адрес события на сайте kudago.com
 * @property participations - список участий агента [AgentPerformanceParticipations]
 *
 * @author Marianna Sabanchieva
 */

data class Agent(
    val id: Int,
    val title: String,
    val slug: String?,
    val description: String?,
    val bodyText: String?,
    val agentType: String?,
    val images: List<Images>?,
    val siteUrl: String?,
    val participations: List<AgentPerformanceParticipations>?
)