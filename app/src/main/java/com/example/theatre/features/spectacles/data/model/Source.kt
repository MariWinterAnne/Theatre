package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("link")
    var link: String? = null
)