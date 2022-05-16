package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("source")
    var source: Source? = Source()
)