package com.example.theatre.features.info.data.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Images model - модель для получения изображения
 *
 * @property imageURL - ссылка на изображение
 *
 * @author Marianna Sabanchieva
 */

data class ImagesModel(
    @SerializedName("image")
    val imageURL: String = String.EMPTY
)