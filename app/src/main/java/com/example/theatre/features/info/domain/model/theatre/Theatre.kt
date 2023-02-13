package com.example.theatre.features.info.domain.model.theatre

import com.example.theatre.core.domain.model.common.Image

/**
 * Theatre - модель для получения данных о театре
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
 * @property images - галерея места [Image]
 * @property description - описание
 * @property bodyText - полное описание
 * @property siteUrl - адрес места на сайте kudago.com
 * @property foreignUrl - сайт места
 * @property coords - координаты места [TheatreCoordinates]
 * @property subway - метро рядом
 * @property favoritesCount - число пользователей, добавивших место в избранное
 * @property commentsCount - число комментариев
 * @property isClosed - закрыто ли место
 * @property categories - список категорий
 * @property tags - тэги места
 *
 */

data class Theatre(
    val id: Int,
    val title: String,
    val shortTitle: String?,
    val slug: String?,
    val address: String?,
    val location: String?,
    val timetable: String?,
    val phone: String?,
    val isStub: Boolean?,
    val images: List<Image>?,
    val description: String?,
    val bodyText: String?,
    val siteUrl: String?,
    val foreignUrl: String?,
    val coords: TheatreCoordinates?,
    val subway: String?,
    val favoritesCount: Int?,
    val commentsCount: Int?,
    val isClosed: Boolean?,
    val categories: List<String>?,
    val tags: List<String>?
)
