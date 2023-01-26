package com.example.theatre.features.poster.data.api.model

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Класс кратких афиш из сети
 *
 * @property id             ид
 * @property images         картинки
 * @property title          заголовок
 * @property description    описание
 * @author Tamerlan Mamukhov on 2022-08-16
 */
data class PosterBriefModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("images")
    val images: List<ImageModel>?,
)