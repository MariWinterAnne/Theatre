package com.example.theatre.features.poster.data.model

import com.example.theatre.core.domain.model.Images
import com.google.gson.annotations.SerializedName


/**
 * Класс кратких афиш из сети
 *
 * @property id                 ид
 * @property images             картинки
 * @property title              заголовок
 * @property description        описание
 * @property publicationDate    дата публикации
 *
 * @author Tamerlan Mamukhov
 * @created 2022-08-15
 */
data class PosterDetailsModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Images>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publicationDate")
    val publicationDate: Long?
)