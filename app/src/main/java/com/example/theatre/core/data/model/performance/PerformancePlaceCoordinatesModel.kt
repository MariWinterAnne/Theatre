package com.example.theatre.core.data.model.performance

import com.google.gson.annotations.SerializedName

/**
 * Performance place coordinates - модель для получения координат театра
 *
 * @property lat - широта
 * @property lon - долгота
 * @constructor Create empty Performance place coordinates
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceCoordinatesModel(
    @SerializedName("lat")
    val lat: Double? = 55.7602196,
    @SerializedName("lon")
    val lon: Double? = 37.6186409
)
