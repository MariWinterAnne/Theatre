package com.example.theatre.features.info.data.model.theatre

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Theatre model - модель для получения данных о театре
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
 * @property images - галерея места [ImagesModel]
 * @property description - описание
 * @property bodyText - полное описание
 * @property siteUrl - адрес места на сайте kudago.com
 * @property foreignUrl - сайт места
 * @property coords - координаты места [TheatreCoordinatesModel]
 * @property subway - метро рядом
 * @property favoritesCount - число пользователей, добавивших место в избранное
 * @property commentsCount - число комментариев
 * @property isClosed - закрыто ли место
 * @property categories - список категорий
 * @property tags - тэги места
 *
 * @author Tamerlan Mamukhov
 */

data class TheatreModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("short_title")
    val shortTitle: String = String.EMPTY,
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("address")
    val address: String = String.EMPTY,
    @SerializedName("location")
    val location: String = String.EMPTY,
    @SerializedName("timetable")
    val timetable: String = String.EMPTY,
    @SerializedName("phone")
    val phone: String = String.EMPTY,
    @SerializedName("is_stub")
    val isStub: Boolean = false,
    @SerializedName("images")
    val images: List<ImageModel>?,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("body_text")
    val bodyText: String = String.EMPTY,
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY,
    @SerializedName("foreign_url")
    val foreignUrl: String = String.EMPTY,
    @SerializedName("coords")
    val coords: TheatreCoordinatesModel?,
    @SerializedName("subway")
    val subway: String = String.EMPTY,
    @SerializedName("favorites_count")
    val favoritesCount: Int = 0,
    @SerializedName("comments_count")
    val commentsCount: Int = 0,
    @SerializedName("is_closed")
    val isClosed: Boolean = false,
    @SerializedName("categories")
    val categories: List<String>?,
    @SerializedName("tags")
    val tags: List<String>?,
)
