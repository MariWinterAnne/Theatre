package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Agents list result - модель для получения списка актеров
 *
 * @property count - количество элементов
 * @property next - ссылка на следующую страницу
 * @property previous - ссылка на предыдущую страницу
 * @property results - список агентов [AgentModel]
 *
 * @author Marianna Sabanchieva
 */

data class AgentsListResult(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: ArrayList<AgentModel> = arrayListOf()
)