package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Get performance
 *
 * @property id - идентификатор
 * @property publication_date - дата публикации
 * @property dates - даты проведения
 * @property title - название
 * @property short_title - короткое название
 * @property slug - слаг
 * @property place - место проведения
 * @property description - описание
 * @property body_text - полное описание
 * @property location - город проведения
 * @property categories - список категорий
 * @property tagline - тэглайн
 * @property age_restriction - возрастное ограничение
 * @property price - стоимость
 * @property is_free - бесплатное ли событие
 * @property images - картинки
 * @property favorites_count - сколько пользователей добавило событие в избранное
 * @property comments_count - число комментариев к событию
 * @property site_url - адрес события на сайте kudago.com
 * @property tags - тэги события
 * @property participants - агенты события
 * @constructor Create empty Get perfomance
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("publication_date")
    val publication_date: Int? = null,
    @SerializedName("dates")
    val dates: ArrayList<PerformanceDates> = arrayListOf(),
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("short_title")
    val short_title: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("place")
    val place: PerformancePlace? = PerformancePlace(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("body_text")
    val body_text: String? = null,
    @SerializedName("location")
    val location: PerformancePlaceLocation? = PerformancePlaceLocation(),
    @SerializedName("categories")
    val categories: ArrayList<String> = arrayListOf(),
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("age_restriction")
    val age_restriction: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("is_free")
    val is_free: Boolean? = null,
    @SerializedName("images")
    val images: ArrayList<ModelImages> = arrayListOf(),
    @SerializedName("favorites_count")
    val favorites_count: Int? = null,
    @SerializedName("comments_count")
    val comments_count: Int? = null,
    @SerializedName("site_url")
    val site_url: String? = null,
    @SerializedName("tags")
    val tags: ArrayList<String> = arrayListOf(),
    @SerializedName("participants")
    val participants: ArrayList<PerformanceParticipants> = arrayListOf()
)
