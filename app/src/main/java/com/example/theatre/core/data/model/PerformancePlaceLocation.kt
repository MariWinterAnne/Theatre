package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance place location
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property performance_place_coordinates - координаты места
 * @property language - язык
 * @constructor Create empty Performance place location
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceLocation(
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("timezone")
    val timezone: String? = null,
    @SerializedName("coords")
    val performance_place_coordinates: PerformancePlaceCoordinates? = PerformancePlaceCoordinates(),
    @SerializedName("language")
    val language: String? = null
)
