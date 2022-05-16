package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Coords(
    @SerializedName("lat")
    var lat: Double? = null,
    @SerializedName("lon")
    var lon: Double? = null
)
