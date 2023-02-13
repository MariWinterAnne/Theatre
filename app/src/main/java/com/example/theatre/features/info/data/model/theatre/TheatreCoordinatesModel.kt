package com.example.theatre.features.info.data.model.theatre

import com.google.gson.annotations.SerializedName

/**
 * Theatre coordinates model - модель для получения координат театра
 *
 * @property lat - широта
 * @property lon - долгота
 *
 * @author Tamerlan Mamukhov
 */

data class TheatreCoordinatesModel(
    @SerializedName("lat")
    val lat: Double = 55.7602196,
    @SerializedName("lon")
    val lon: Double = 37.6186409
)
