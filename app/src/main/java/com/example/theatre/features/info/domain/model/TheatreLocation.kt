package com.example.theatre.features.info.domain.model

/**
 * Theatre location - модель для получения местонахождения театра
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property language - язык
 *
 * @author Marianna Sabanchieva
 */

data class TheatreLocation(
    val slug: String? = null,
    val name: String? = null,
    val timezone: String? = null,
    val language: String? = null
)
