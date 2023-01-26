package com.example.theatre.core.data.mappers

import com.example.theatre.core.data.model.common.ImageModel
import com.example.theatre.core.domain.model.common.Images

fun ImageModel.toImages() = Images(
    imageURL = imageURL
)
