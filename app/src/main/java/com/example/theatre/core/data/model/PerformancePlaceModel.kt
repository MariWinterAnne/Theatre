package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance place - модель для детализации места постановки
 *
 * @property id - идентификатор
 * @property title - название
 * @property short_title - короткое название
 * @property slug - слаг
 * @property description - описание
 * @property address - адрес
 * @property phone - телефон
 * @property subway - метро рядом
 * @property location - город
 * @property site_url - адрес места на сайте kudago.com
 * @property foreign_url - сайт места
 * @property is_closed - закрыто ли место
 * @property performance_place_coordinates - координаты места [PerformancePlaceCoordinatesModel]
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlaceModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("short_title")
    val short_title: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("subway")
    val subway: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("site_url")
    val site_url: String? = null,
    @SerializedName("foreign_url")
    val foreign_url: String? = null,
    @SerializedName("is_closed")
    val is_closed: Boolean? = null,
    @SerializedName("coords")
    val performance_place_coordinates: PerformancePlaceCoordinatesModel? = PerformancePlaceCoordinatesModel()
)
