package com.example.theatre.features.poster.domain.model

import com.example.theatre.core.domain.model.common.Image
import com.example.theatre.core.domain.model.common.performance.PerformanceDates
import com.example.theatre.core.domain.model.common.performance.PerformanceParticipants

/**
 * @author Tamerlan Mamukhov
 * @created 2022-08-15
 */
data class PosterDetails(
    val id: Int,
    val images: List<Image>?,
    val title: String,
    val shortTitle: String?,
    val description: String?,
    val tagline: String?,
    val publicationDate: Long?,
    val price: String?,
    val ageRestriction: String?,
    val dates: List<PerformanceDates>?,
    val participants: List<PerformanceParticipants>?,
    val bodyText: String?,
    val siteUrl: String?
)
