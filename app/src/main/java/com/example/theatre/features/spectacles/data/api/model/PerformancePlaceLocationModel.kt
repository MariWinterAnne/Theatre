package com.example.theatre.features.spectacles.data.api.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Performance place location - модель для получения доп. деталей о месте постановки
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property performancePlaceCoordinates - координаты места [PerformancePlaceCoordinatesModel]
 * @property language - язык
 *
 * @author Tamerlan Mamukhov
 */

data class PerformancePlaceLocationModel(
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("name")
    val name: String = String.EMPTY,
    @SerializedName("timezone")
    val timezone: String = String.EMPTY,
    @SerializedName("coords")
    val performancePlaceCoordinates: PerformancePlaceCoordinatesModel? = null,
    @SerializedName("language")
    val language: String = String.EMPTY
)
