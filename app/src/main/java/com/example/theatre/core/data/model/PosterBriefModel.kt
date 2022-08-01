package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Класс афиши краткой?
 * TODO: подумать над тем, стоит ли это иметь. Может, стоит добавить просто один класс в дата и потом конвертировать его в два в домайн?
 *
 * @property id
 * @property title
 * @property description
 * @property images
 * @constructor Create empty Poster brief model
 */
data class PosterBriefModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("images")
    val images: List<ModelImages>? = listOf(),
)
