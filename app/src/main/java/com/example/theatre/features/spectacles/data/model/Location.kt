package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("timezone")
    var timezone: String? = null,
    @SerializedName("coords")
    var coords: Coords? = Coords(),
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("currency")
    var currency: String? = null
)
