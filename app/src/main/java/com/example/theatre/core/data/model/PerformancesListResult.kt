package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Performances list result - модель для получения списка постановок
 *
 * @property count - количество элементов
 * @property next - ссылка на следующую страницу
 * @property previous - ссылка на предыдущую страницу
 * @property results - список постановок [PerformanceModel]
 *
 * @author Marianna Sabanchieva
 */

data class PerformancesListResult(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = String.EMPTY,
    @SerializedName("previous")
    val previous: String? = String.EMPTY,
    @SerializedName("results")
    val results: List<PerformanceModel> = listOf()
)