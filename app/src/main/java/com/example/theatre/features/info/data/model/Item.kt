package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("ctype" )
    var ctype: String? = null
)
