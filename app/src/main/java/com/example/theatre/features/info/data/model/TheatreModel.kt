package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

/**
 * Get theatre
 *
 * @property id - идентификатор
 * @property title - название
 * @property shortTitle - короткое название
 * @property slug - слаг
 * @property address - адрес
 * @property location - город
 * @property timetable - расписание
 * @property phone - телефон
 * @property isStub - является ли заглушкой
 * @property images - галерея места
 * @property description - описание
 * @property bodyText - полное описание
 * @property siteUrl - адрес места на сайте kudago.com
 * @property foreignUrl - сайт места
 * @property coords - координаты места
 * @property subway - метро рядом
 * @property favoritesCount - число пользователей, добавивших место в избранное
 * @property commentsCount - число комментариев
 * @property isClosed - закрыто ли место
 * @property categories - список категорий
 * @property tags - тэги места
 *
 */

data class TheatreModel(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("short_title")
    var shortTitle: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("location")
    var location: String? = null,
    @SerializedName("timetable")
    var timetable: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("is_stub")
    var isStub: Boolean? = null,
    @SerializedName("images")
    var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("body_text")
    var bodyText: String? = null,
    @SerializedName("site_url")
    var siteUrl: String? = null,
    @SerializedName("foreign_url")
    var foreignUrl: String? = null,
    @SerializedName("coords")
    var coords: Coords? = Coords(),
    @SerializedName("subway")
    var subway: String? = null,
    @SerializedName("favorites_count")
    var favoritesCount: Int? = null,
    @SerializedName("comments_count")
    var commentsCount: Int? = null,
    @SerializedName("is_closed")
    var isClosed: Boolean? = null,
    @SerializedName("categories")
    var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("tags")
    var tags: ArrayList<String> = arrayListOf(),
)
