package com.example.theatre.features.info.domain.model

import com.example.theatre.features.info.data.model.Coords
import com.example.theatre.features.info.data.model.Images

/**
 * Theatre
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

data class Theatre(
    var id: Int?,
    var title: String?,
    var shortTitle: String?,
    var slug: String?,
    var address: String?,
    var location: String?,
    var timetable: String?,
    var phone: String?,
    var isStub: Boolean?,
    var images: ArrayList<Images>,
    var description: String?,
    var bodyText: String?,
    var siteUrl: String?,
    var foreignUrl: String?,
    var coords: Coords?,
    var subway: String?,
    var favoritesCount: Int?,
    var commentsCount: Int?,
    var isClosed: Boolean?,
    var categories: ArrayList<String>,
    var tags: ArrayList<String>
)
