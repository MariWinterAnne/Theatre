package com.example.theatre.features.poster.domain.model

import com.example.theatre.core.domain.model.common.Image

/**
 * Класс представления кратких афиш
 *
 * @property id             ид
 * @property image          картинка
 * @property title          заголовок
 * @property description    описание
 * @author Tamerlan Mamukhov on 2022-08-16
 */
data class PosterBriefItem(
    val id: Int,
    val image: Image?,
    val title: String?,
    val description: String?
)