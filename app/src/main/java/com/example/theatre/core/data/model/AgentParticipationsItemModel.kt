package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent participations item - модель для получения постановок, в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование
 * @property description - описание
 * @property itemUrl - адрес
 * @property ctype - тип элемента
 * @property performancePlace - место [PerformancePlaceModel]
 * @property firstImage - главное изображение [ModelImages]
 * @property ageRestriction - ограничение по возрасту
 *
 * @author Marianna Sabanchieva
 */

data class AgentParticipationsItemModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String = String.EMPTY,
    @SerializedName("description")
    val description: String = String.EMPTY,
    @SerializedName("item_url")
    val itemUrl: String = String.EMPTY,
    @SerializedName("ctype")
    val ctype: String = String.EMPTY,
    @SerializedName("place")
    val performancePlace: PerformancePlaceModel? = null,
    @SerializedName("first_image")
    val firstImage: ModelImages? = null,
    @SerializedName("age_restriction")
    val ageRestriction: String = String.EMPTY
)
