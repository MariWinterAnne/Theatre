package com.example.theatre.features.spectacles.data.model

import com.example.theatre.features.spectacles.domain.model.Role
import com.google.gson.annotations.SerializedName

data class Participations(
    @SerializedName("role")
    var role: Role? = Role(),
    @SerializedName("item")
    var item: Item? = Item()
)
