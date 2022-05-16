package com.example.theatre.features.spectacles.domain.model

import com.example.theatre.features.spectacles.data.model.Images
import com.example.theatre.features.spectacles.data.model.Participations
import com.google.gson.annotations.SerializedName

data class Agent(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("body_text")
    var bodyText: String? = null,
    @SerializedName("agent_type")
    var agentType: String? = null,
    @SerializedName("images")
    var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("site_url")
    var siteUrl: String? = null,
    @SerializedName("participations")
    var participations : ArrayList<Participations> = arrayListOf()
)
