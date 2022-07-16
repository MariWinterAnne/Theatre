package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Get performance - модель для получения детализации постановки
 *
 * @property id - идентификатор
 * @property publication_date - дата публикации
 * @property dates - даты проведения [PerformanceDatesModel]
 * @property title - название
 * @property short_title - короткое название
 * @property slug - слаг
 * @property place - место проведения [PerformancePlaceModel]
 * @property description - описание
 * @property body_text - полное описание
 * @property location - город проведения [PerformancePlaceLocationModel]
 * @property categories - список категорий
 * @property tagline - тэглайн
 * @property age_restriction - возрастное ограничение
 * @property price - стоимость
 * @property is_free - бесплатное ли событие
 * @property images - картинки [ModelImages]
 * @property favorites_count - сколько пользователей добавило событие в избранное
 * @property comments_count - число комментариев к событию
 * @property site_url - адрес события на сайте kudago.com
 * @property tags - тэги события
 * @property participants - агенты события [PerformanceParticipantsModel]
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("publication_date")
    val publication_date: Long? = null,
    @SerializedName("dates")
    val dates: ArrayList<PerformanceDatesModel> = arrayListOf(),
    @SerializedName("title")
    val title: String,
    @SerializedName("short_title")
    val short_title: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("place")
    val place: PerformancePlaceModel? = PerformancePlaceModel(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("body_text")
    val body_text: String? = null,
    @SerializedName("location")
    val location: PerformancePlaceLocationModel? = PerformancePlaceLocationModel(),
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
    val participants: ArrayList<PerformanceParticipantsModel> = arrayListOf()
)
