package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class GetRole(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("name")
    var name: String? = null
)
