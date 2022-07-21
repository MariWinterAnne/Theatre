package com.example.theatre.features.info.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Theatre location model - модель для получения местонахождения театра
 *
 * @property slug - слаг
 * @property name - наименование
 * @property timezone - часовой пояс
 * @property language - язык
 *
 * @author Marianna Sabanchieva
 */

data class TheatreLocationModel(
    @SerializedName("slug")
    val slug: String = String.EMPTY,
    @SerializedName("name")
    val name: String = String.EMPTY,
    @SerializedName("timezone")
    val timezone: String = String.EMPTY,
    @SerializedName("language")
    val language: String = String.EMPTY
)
