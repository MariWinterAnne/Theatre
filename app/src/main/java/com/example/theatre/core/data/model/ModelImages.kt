package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Model images
 *
 * @property image - ссылка на изображение
 * @constructor Create empty Model images
 *
 * @author Marianna Sabanchieva
 */

data class ModelImages(
    @SerializedName("image")
    val image: String? = null
)