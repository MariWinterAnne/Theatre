package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance place location - модель для получения доп. деталей о месте постановки
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property performance_place_coordinates - координаты места [PerformancePlaceCoordinatesModel]
 * @property language - язык
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceLocationModel(
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("timezone")
    val timezone: String? = null,
    @SerializedName("coords")
    val performance_place_coordinates: PerformancePlaceCoordinatesModel? = PerformancePlaceCoordinatesModel(),
    @SerializedName("language")
    val language: String? = null
)
