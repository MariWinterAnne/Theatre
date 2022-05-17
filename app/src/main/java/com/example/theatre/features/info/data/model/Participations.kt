package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class Participations(
    @SerializedName("role")
    var role: Role? = Role(),
    @SerializedName("item")
    var item: Item? = Item()
)
