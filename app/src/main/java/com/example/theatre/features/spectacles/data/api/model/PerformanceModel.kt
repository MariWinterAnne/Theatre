package com.example.theatre.features.spectacles.data.api.model

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Get performance - модель для получения детализации постановки
 *
 * @property id - идентификатор
 * @property publicationDate - дата публикации
 * @property dates - даты проведения [PerformanceDatesModel]
 * @property title - название
 * @property shortTitle - короткое название
 * @property slug - слаг
 * @property place - место проведения [PerformancePlaceModel]
 * @property description - описание
 * @property bodyText - полное описание
 * @property location - город проведения [PerformancePlaceLocationModel]
 * @property categories - список категорий
 * @property tagline - тэглайн
 * @property ageRestriction - возрастное ограничение
 * @property price - стоимость
 * @property isFree - бесплатное ли событие
 * @property images - картинки [ImageModel]
 * @property favoritesCount - сколько пользователей добавило событие в избранное
 * @property commentsCount - число комментариев к событию
 * @property siteUrl - адрес события на сайте kudago.com
 * @property tags - тэги события
 * @property participants - агенты события [PerformanceParticipantsModel]
 *
 * @author Tamerlan Mamukhov
 */

data class PerformanceModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("publication_date")
    val publicationDate: Long? = 0,
    @SerializedName("dates")
    val dates: List<PerformanceDatesModel>? = listOf(),
    @SerializedName("title")
    val title: String,
    @SerializedName("short_title")
    val shortTitle: String = String.EMPTY,
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("place")
    val place: PerformancePlaceModel? = null,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("body_text")
    val bodyText: String = String.EMPTY,
    @SerializedName("location")
    val location: PerformancePlaceLocationModel? = null,
    @SerializedName("categories")
    val categories: List<String>? = listOf(),
    @SerializedName("tagline")
    val tagline: String = String.EMPTY,
    @SerializedName("age_restriction")
    val ageRestriction: String = String.EMPTY,
    @SerializedName("price")
    val price: String = String.EMPTY,
    @SerializedName("is_free")
    val isFree: Boolean? = false,
    @SerializedName("images")
    val images: List<ImageModel>? = listOf(),
    @SerializedName("favorites_count")
    val favoritesCount: Int? = 0,
    @SerializedName("comments_count")
    val commentsCount: Int? = 0,
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY,
    @SerializedName("tags")
    val tags: List<String>? = listOf(),
    @SerializedName("participants")
    val participants: List<PerformanceParticipantsModel>? = listOf()
)
