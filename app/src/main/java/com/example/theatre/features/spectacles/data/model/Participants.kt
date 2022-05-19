package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Participants(
    @SerializedName("role")
    var role: GetRole? = GetRole(),
    @SerializedName("agent")
    var agent: GetAgent? = GetAgent(),
)
