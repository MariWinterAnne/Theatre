package com.example.theatre.features.poster.domain.model

import com.example.theatre.core.domain.model.Images

data class PosterBriefItem(
    val id: Int,
    val image: Images?,
    val title: String?,
    val description: String?
)