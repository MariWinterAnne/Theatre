package com.example.theatre.features.info.data.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Agents list result - модель для получения списка актеров
 *
 * @property count
 * @property next
 * @property previous
 * @property results [AgentModel]
 *
 * @author Marianna Sabanchieva
 */
data class AgentsListResult(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("next")
    val next: String = String.EMPTY,
    @SerializedName("previous")
    val previous: String = String.EMPTY,
    @SerializedName("results")
    val results: List<AgentModel> = listOf(),
)