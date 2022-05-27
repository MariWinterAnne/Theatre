package com.example.theatre.core.domain.model

import com.example.theatre.core.data.model.PerformanceDates
import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.data.model.ModelImages
import com.example.theatre.core.data.model.PerformanceParticipants

/**
 * Performance
 *
 * @property id - идентификатор
 * @property publication_date - дата публикации
 * @property dates - даты проведения
 * @property title - название
 * @property short_title - короткое название
 * @property slug - слаг
 * @property performance_place - место проведения
 * @property description - описание
 * @property body_text - полное описание
 * @property performance_place_location - город проведения
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
 *
 * @author Marianna Sabanchieva
 */

data class Performance(
    val id: Int?,
    val publication_date: Int?,
    val dates: ArrayList<PerformanceDates>,
    val title: String?,
    val short_title: String?,
    val slug: String?,
    val place: PerformancePlace?,
    val description: String?,
    val body_text: String?,
    val location: PerformancePlaceLocation?,
    val categories: ArrayList<String>,
    val tagline: String?,
    val age_restriction: String?,
    val price: String?,
    val is_free: Boolean?,
    val images: ArrayList<ModelImages>,
    val favorites_count: Int?,
    val comments_count: Int?,
    val site_url: String?,
    val tags: ArrayList<String>,
    val participants: ArrayList<PerformanceParticipants>
)
