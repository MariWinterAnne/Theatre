package com.example.theatre.core.domain.model

/**
 * Performance place - модель для детализации места постановки
 *
 * @property id - идентификатор
 * @property title - название
 * @property short_title - короткое название
 * @property slug - слаг
 * @property description - описание
 * @property address - адрес
 * @property phone - телефон
 * @property subway - метро рядом
 * @property location - город
 * @property site_url - адрес места на сайте kudago.com
 * @property foreign_url - сайт места
 * @property is_closed - закрыто ли место
 * @property performance_place_coordinates - координаты места [PerformancePlaceCoordinates]
 *
 * @author Marianna Sabanchieva
 */

data class PerformancePlace(
    val id: Int?,
    val title: String?,
    val short_title: String?,
    val slug: String?,
    val description: String?,
    val address: String?,
    val phone: String?,
    val subway: String?,
    val location: String?,
    val site_url: String?,
    val foreign_url: String?,
    val is_closed: Boolean?,
    val performance_place_coordinates: PerformancePlaceCoordinates?
)
