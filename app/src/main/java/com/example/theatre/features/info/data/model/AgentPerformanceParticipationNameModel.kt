package com.example.theatre.features.info.data.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agent performance participation name model - модель для расшифровки постановок,
 * в которых задействован актер
 *
 * @property id - идентификатор
 * @property title - наименование постановки
 * @property ctype - жанр постановки
 *
 * @author Marianna Sabanchieva
 */

data class AgentPerformanceParticipationNameModel(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = String.EMPTY,
    @SerializedName("ctype" )
    val ctype: String = String.EMPTY
)
