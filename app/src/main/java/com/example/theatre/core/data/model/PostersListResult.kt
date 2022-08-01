package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Класс ответа с афишами краткими
 * TODO: подумать над тем, стоит ли это иметь. Может, стоит добавить просто один класс в дата и потом конвертировать его в два в домайн?
 *
 * @property count
 * @property next
 * @property previous
 * @property results
 * @constructor Create empty Posters list result
 */
data class PostersListResult(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String = String.EMPTY,
    @SerializedName("previous")
    val previous: String = String.EMPTY,
    @SerializedName("results")
    val results: List<PosterBriefModel> = listOf()
)
