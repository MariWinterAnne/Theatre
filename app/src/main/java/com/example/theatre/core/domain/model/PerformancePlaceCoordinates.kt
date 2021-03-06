package com.example.theatre.core.domain.model

/**
 * Performance place coordinates - модель для получения координат театра
 *
 * @property lat - широта
 * @property lon - долгота
 * @constructor Create empty Performance place coordinates
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceCoordinates(
    val lat: Double?,
    val lon: Double?
)
