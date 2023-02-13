package com.example.theatre.core.domain.model.common.performance

/**
 * Performance place location - модель для получения доп. деталей о месте постановки
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property performancePlaceCoordinates - координаты места [PerformancePlaceCoordinates]
 * @property language - язык
 *
 * @author Tamerlan Mamukhov
 */

data class PerformancePlaceLocation(
    val slug: String?,
    val name: String?,
    val timezone: String?,
    val performancePlaceCoordinates: PerformancePlaceCoordinates?,
    val language: String?
)
