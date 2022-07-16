package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agent participations item - модель для получения постановок, в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование
 * @property description - описание
 * @property item_url - адрес
 * @property ctype - тип элемента
 * @property performance_place - место [PerformancePlaceModel]
 * @property first_image - главное изображение [ModelImages]
 * @property age_restriction - ограничение по возрасту
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsItemModel(
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
    val performance_place: PerformancePlaceModel? = PerformancePlaceModel(),
    @SerializedName("first_image")
    val first_image: ModelImages? = ModelImages(),
    @SerializedName("age_restriction")
    val age_restriction: String? = null
)
