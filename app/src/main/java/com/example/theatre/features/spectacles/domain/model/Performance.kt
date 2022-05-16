package com.example.theatre.features.spectacles.domain.model

import com.example.theatre.features.spectacles.data.model.*

/**
 * Performance
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
 * @constructor Create empty Performance
 */

data class Performance(
    val id: Int?,
    val publication_date: Int?,
    val dates: ArrayList<Dates>,
    val title: String?,
    val short_title: String?,
    val slug: String?,
    val place: Place?,
    val description: String?,
    val body_text: String?,
    val location: Location?,
    val categories: ArrayList<String>,
    val tagline: String?,
    val age_restriction: String?,
    val price: String?,
    val is_free: Boolean?,
    val images: ArrayList<Images>,
    val favorites_count: Int?,
    val comments_count: Int?,
    val site_url: String?,
    val tags: ArrayList<String>,
    val participants: ArrayList<Participants>
)
