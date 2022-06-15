package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance place coordinates
 *
 * @property lat - широта
 * @property lon - долгота
 * @constructor Create empty Performance place coordinates
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceCoordinates(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lon")
    val lon: Double? = null
)
