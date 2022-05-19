package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class RequestResultTheatre(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: ArrayList<TheatreModel> = arrayListOf()
)