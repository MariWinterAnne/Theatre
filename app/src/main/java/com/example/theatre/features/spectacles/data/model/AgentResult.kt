package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class AgentResult(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null,
    @SerializedName("results") var results: ArrayList<GetAgent> = arrayListOf()
)