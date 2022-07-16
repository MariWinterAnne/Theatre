package com.example.theatre.core.domain.model

/**
 * Performance place location - модель для получения доп. деталей о месте постановки
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property performance_place_coordinates - координаты места [PerformancePlaceCoordinates]
 * @property language - язык
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceLocation(
    val slug: String?,
    val name: String?,
    val timezone: String?,
    val performance_place_coordinates: PerformancePlaceCoordinates?,
    val language: String?
)
