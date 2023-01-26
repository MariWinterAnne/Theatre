package com.example.theatre.core.data.model.common

import com.google.gson.annotations.SerializedName

/**
 * Класс результатов запроса в сеть
 *
 * @param T                 тип данных
 * @property data           данные
 * @author Tamerlan Mamukhov
 */
data class ItemsListResultModel<T>(
    @SerializedName("results")
    val data: List<T>
)