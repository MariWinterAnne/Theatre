package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent participations item
 *
 * @property id - идентификатор
 * @property title - наименование
 * @property description - описание
 * @property item_url - адрес
 * @property ctype - тип элемента
 * @property performance_place - место
 * @property first_image - главное изображение
 * @property age_restriction - ограничение по возрасту
 * @constructor Create empty Agent participations item
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsItem(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("item_url")
    val item_url: String? = null,
    @SerializedName("ctype")
    val ctype: String? = null,
    @SerializedName("place")
    val performance_place: PerformancePlace? = PerformancePlace(),
    @SerializedName("first_image")
    val first_image: ModelImages? = ModelImages(),
    @SerializedName("age_restriction")
    val age_restriction: String? = null
)
