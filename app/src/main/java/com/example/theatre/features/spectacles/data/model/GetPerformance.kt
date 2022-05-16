package com.example.theatre.features.spectacles.data.model

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
 */

data class GetPerformance(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("publication_date")
    var publicationDate: Int? = null,
    @SerializedName("dates")
    var dates: ArrayList<Dates> = arrayListOf(),
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("short_title")
    var shortTitle: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("place")
    var place: Place? = Place(),
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("body_text")
    var bodyText: String? = null,
    @SerializedName("location")
    var location: Location? = Location(),
    @SerializedName("categories")
    var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("age_restriction")
    var ageRestriction: String? = null,
    @SerializedName("price")
    var price: String? = null,
    @SerializedName("is_free")
    var isFree: Boolean? = null,
    @SerializedName("images")
    var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("favorites_count")
    var favoritesCount: Int? = null,
    @SerializedName("comments_count")
    var commentsCount: Int? = null,
    @SerializedName("site_url")
    var siteUrl: String? = null,
    @SerializedName("tags")
    var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("participants")
    var participants: ArrayList<Participants> = arrayListOf()
)
