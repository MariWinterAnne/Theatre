package com.example.theatre.core.domain.model.common.performance

import com.example.theatre.core.domain.model.common.Image

/**
 * Performance - модель для получения детализации постановки
 *
 * @property id - идентификатор
 * @property publicationDate - дата публикации
 * @property dates - даты проведения [PerformanceDates]
 * @property title - название
 * @property shortTitle - короткое название
 * @property slug - слаг
 * @property place - место проведения [PerformancePlace]
 * @property description - описание
 * @property bodyText - полное описание
 * @property location - город проведения [PerformancePlaceLocation]
 * @property categories - список категорий
 * @property tagline - тэглайн
 * @property ageRestriction - возрастное ограничение
 * @property price - стоимость
 * @property isFree - бесплатное ли событие
 * @property images - картинки [Image]
 * @property favoritesCount - сколько пользователей добавило событие в избранное
 * @property commentsCount - число комментариев к событию
 * @property siteUrl - адрес события на сайте kudago.com
 * @property tags - тэги события
 * @property participants - агенты события [PerformanceParticipants]
 *
 * @author Tamerlan Mamukhov
 */

data class Performance(
    val id: Int,
    val publicationDate: Long?,
    val dates: List<PerformanceDates>?,
    val title: String,
    val shortTitle: String?,
    val slug: String?,
    val place: PerformancePlace?,
    val description: String?,
    val bodyText: String?,
    val location: PerformancePlaceLocation?,
    val categories: List<String>?,
    val tagline: String?,
    val ageRestriction: String?,
    val price: String?,
    val isFree: Boolean?,
    val images: List<Image>?,
    val favoritesCount: Int?,
    val commentsCount: Int?,
    val siteUrl: String?,
    val tags: List<String>?,
    val participants: List<PerformanceParticipants>?
)
