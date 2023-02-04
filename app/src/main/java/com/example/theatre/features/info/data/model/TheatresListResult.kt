package com.example.theatre.features.info.data.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Theatre list result - модель для получения списка театров
 *
 * @property count - количество элементов
 * @property next - ссылка на следующую страницу
 * @property previous - ссылка на предыдущую страницу
 * @property results - список театров [TheatreModel]
 *
 * @author Marianna Sabanchieva
 */

data class TheatresListResult(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("next")
    val next: String = String.EMPTY,
    @SerializedName("previous")
    val previous: String = String.EMPTY,
    @SerializedName("results")
    val results: List<TheatreModel> = listOf()
)