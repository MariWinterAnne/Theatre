package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Model images - модель для получения изображения
 *
 * @property image - ссылка на изображение
 * @author Marianna Sabanchieva
 */

data class ModelImages(
    @SerializedName("image")
    val image: String? = null
)