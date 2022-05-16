package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("favorites_count")
    var favoritesCount: Int? = null,
    @SerializedName("comments_count")
    var commentsCount: Int? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("item_url")
    var itemUrl: String? = null,
    @SerializedName("disable_comments")
    var disableComments: Boolean? = null,
    @SerializedName("ctype")
    var ctype: String? = null,
    @SerializedName("place")
    var place: Place? = Place(),
    @SerializedName("first_image")
    var firstImage: FirstImage? = FirstImage(),
    @SerializedName("age_restriction")
    var ageRestriction: String? = null,
)
