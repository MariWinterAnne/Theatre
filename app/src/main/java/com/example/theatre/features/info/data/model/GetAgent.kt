package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class GetAgent(
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
    @SerializedName("is_stub")
    var isStub: Boolean? = null,
    @SerializedName("participations")
    var participations: ArrayList<Participations> = arrayListOf()
)
