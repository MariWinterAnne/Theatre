package com.example.theatre.core.data.model.common

import com.google.gson.annotations.SerializedName

/**
 * @author Tamerlan Mamukhov
 * @created 2022-11-20
 */
data class SingeItemResultModel<T>(
    @SerializedName("data")
    val data: T
)