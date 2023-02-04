package com.example.theatre.features.poster.data.model

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.features.spectacles.data.api.model.PerformanceDatesModel
import com.example.theatre.features.spectacles.data.api.model.PerformanceParticipantsModel
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
    val images: List<ImageModel>? = listOf(),
    @SerializedName("title")
    val title: String,
    @SerializedName("short_title")
    val shortTitle: String = String.EMPTY,
    @SerializedName("description")
    val description: String?,
    @SerializedName("tagline")
    val tagline: String = String.EMPTY,
    @SerializedName("publication_date")
    val publicationDate: Long?,
    val price: String?,
    @SerializedName("age_restriction")
    val ageRestriction: String = String.EMPTY,
    @SerializedName("dates")
    val dates: List<PerformanceDatesModel>? = listOf(),
    @SerializedName("participants")
    val participants: List<PerformanceParticipantsModel>? = listOf(),
    @SerializedName("body_text")
    val bodyText: String = String.EMPTY,
    @SerializedName("site_url")
    val siteUrl: String = String.EMPTY
)