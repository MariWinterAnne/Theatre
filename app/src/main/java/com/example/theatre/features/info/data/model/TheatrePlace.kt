package com.example.theatre.features.info.data.model

import com.google.gson.annotations.SerializedName

data class TheatrePlace(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("short_title")
    var shortTitle: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("body_text")
    var bodyText: String? = null,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("subway")
    var subway: String? = null,
    @SerializedName("location")
    var location: String? = null,
    @SerializedName("images")
    var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("site_url")
    var siteUrl: String? = null,
    @SerializedName("foreign_url")
    var foreignUrl: String? = null,
    @SerializedName("is_closed")
    var isClosed: Boolean? = null,
    @SerializedName("coords")
    var coords: Coords? = Coords(),
    @SerializedName("is_stub")
    var isStub: Boolean? = null,
    @SerializedName("timetable")
    var timetable: String? = null
)
