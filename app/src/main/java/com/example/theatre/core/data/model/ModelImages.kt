package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Model images - модель для получения изображения
 *
 * @property imageURL - ссылка на изображение
 * @author Marianna Sabanchieva
 */

data class ModelImages(
    @SerializedName("image")
    val imageURL: String? = String.EMPTY
)