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
    val id: Int?,
    val title: String?,
    val shortTitle: String?,
    val slug: String?,
    val address: String?,
    val location: String?,
    val timetable: String?,
    val phone: String?,
    val isStub: Boolean?,
    val images: ArrayList<Images>,
    val description: String?,
    val bodyText: String?,
    val siteUrl: String?,
    val foreignUrl: String?,
    val coords: Coords?,
    val subway: String?,
    val favoritesCount: Int?,
    val commentsCount: Int?,
    val isClosed: Boolean?,
    val categories: ArrayList<String>,
    val tags: ArrayList<String>
)
