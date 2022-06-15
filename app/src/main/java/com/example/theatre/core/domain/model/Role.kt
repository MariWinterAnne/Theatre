package com.example.theatre.core.domain.model

/**
 * Role
 *
 * @property id - идентификатор
 * @property slug - слаг
 * @property name - наименование роли
 * @constructor Create empty Role
 *
 * @author Marianna Sabanchieva
 */

data class Role(
    val id: Int? = null,
    val slug: String? = null,
    val name: String? = null
)
