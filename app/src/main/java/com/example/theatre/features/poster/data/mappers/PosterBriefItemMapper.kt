package com.example.theatre.features.poster.data.mappers

import com.example.theatre.core.domain.model.common.Performance
import com.example.theatre.features.poster.domain.model.PosterBriefItem

fun Performance.toPosterBriefItem() = PosterBriefItem(
    id = id,
    image = images?.first(),
    title = title,
    description = description
)

