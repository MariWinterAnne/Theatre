package com.example.theatre.core.domain.model.common.performance

/**
 * Performance place - модель для детализации места постановки
 *
 * @property id - идентификатор
 * @property title - название
 * @property shortTitle - короткое название
 * @property slug - слаг
 * @property description - описание
 * @property address - адрес
 * @property phone - телефон
 * @property subway - метро рядом
 * @property location - город
 * @property siteUrl - адрес места на сайте kudago.com
 * @property foreignUrl - сайт места
 * @property isClosed - закрыто ли место
 * @property performancePlaceCoordinates - координаты места [PerformancePlaceCoordinates]
 *
 * @author Tamerlan Mamukhov
 */

data class PerformancePlace(
    val id: Int?,
    val title: String?,
    val shortTitle: String?,
    val slug: String?,
    val description: String?,
    val address: String?,
    val phone: String?,
    val subway: String?,
    val location: String?,
    val siteUrl: String?,
    val foreignUrl: String?,
    val isClosed: Boolean?,
    val performancePlaceCoordinates: PerformancePlaceCoordinates?
)
