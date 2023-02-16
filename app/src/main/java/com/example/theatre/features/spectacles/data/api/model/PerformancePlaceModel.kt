package com.example.theatre.features.spectacles.data.api.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Performance place - модель для детализации места постановки
 *
 * @property id - идентификатор
 * @property title - название
 * @property shortTitle - короткое название
 * @property slug - слаг
 * @property description - описание
 * @property address - адрес
 * @property phone - телефон
 * @property subway - метро рядом
 * @property location - город
 * @property siteUrl - адрес места на сайте kudago.com
 * @property foreignUrl - сайт места
 * @property isClosed - закрыто ли место
 * @property performancePlaceCoordinates - координаты места [PerformancePlaceCoordinatesModel]
 *
 * @author Tamerlan Mamukhov
 */

data class PerformancePlaceModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String = String.EMPTY,
    @SerializedName("short_title")
    val shortTitle: String = String.EMPTY,
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("address")
    val address: String = String.EMPTY,
    @SerializedName("phone")
    val phone: String = String.EMPTY,
    @SerializedName("subway")
    val subway: String = String.EMPTY,
    @SerializedName("location")
    val location: String = String.EMPTY,
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY,
    @SerializedName("foreign_url")
    val foreignUrl: String = String.EMPTY,
    @SerializedName("is_closed")
    val isClosed: Boolean? = false,
    @SerializedName("coords")
    val performancePlaceCoordinates: PerformancePlaceCoordinatesModel? = null
)
