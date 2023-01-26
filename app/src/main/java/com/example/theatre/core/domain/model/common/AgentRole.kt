package com.example.theatre.core.domain.model.common

/**
 * Agent role - модель для получения деталей о роли
 *
 * @property id - идентификатор
 * @property slug - слаг
 * @property name - наименование роли
 *
 * @author Marianna Sabanchieva
 */

data class AgentRole(
    val id: Int?,
    val slug: String?,
    val name: String?
)
