package com.example.theatre.features.info.domain.model.theatre

/**
 * Theatre location - модель для получения местонахождения театра
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property language - язык
 *
 * @author Tamerlan Mamukhov
 */

data class TheatreLocation(
    val slug: String?,
    val name: String?,
    val timezone: String?,
    val language: String?
)
