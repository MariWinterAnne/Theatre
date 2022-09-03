package com.example.theatre.features.poster.domain.model

import com.example.theatre.core.domain.model.Images

/**
 * @author Tamerlan Mamukhov
 * @created 2022-08-15
 */
data class PosterDetails(
    val id: Int,
    val images: List<Images>?,
    val title: String?,
    val description: String?,
    val publicationDate: Long?
)
