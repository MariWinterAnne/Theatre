package com.example.theatre.core.data.model.common

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Модель для получения изображения
 *
 * @property imageURL - ссылка на изображение
 * @author Tamerlan Mamukhov
 */

data class ImageModel(
    @SerializedName("image")
    val imageURL: String = String.EMPTY
)