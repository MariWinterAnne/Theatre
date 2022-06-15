package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performances list result
 *
 * @property count - количество элементов
 * @property next - ссылка на следующую страницу
 * @property previous - ссылка на предыдущую страницу
 * @property results - список постановок
 * @constructor Create empty Performances list result
 *
 * @author Marianna Sabanchieva
 */

data class PerformancesListResult(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: ArrayList<PerformanceModel> = arrayListOf()
)