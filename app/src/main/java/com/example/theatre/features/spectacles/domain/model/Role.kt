package com.example.theatre.features.spectacles.domain.model

import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("name")
    var name: String? = null
)
