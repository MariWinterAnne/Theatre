package com.example.theatre.core.data.model

import com.example.theatre.core.utils.StringUtils.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Модель для получения изображения
 *
 * @property imageURL - ссылка на изображение
 * @author Marianna Sabanchieva
 */

data class ImageModel(
    @SerializedName("image")
    val imageURL: String = String.EMPTY
)