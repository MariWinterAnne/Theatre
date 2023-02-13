package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.domain.model.common.Image

fun ImageModel.toImage() = Image(
    imageURL = imageURL
)
