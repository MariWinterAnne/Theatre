package com.example.theatre.features.spectacles.data.model

import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("start_date")
    var startDate: String? = null,
    @SerializedName("start_time")
    var startTime: String? = null,
    @SerializedName("start")
    var start: Int? = null,
    @SerializedName("end_date")
    var endDate: String? = null,
    @SerializedName("end_time")
    var endTime: String? = null,
    @SerializedName("end")
    var end: Int? = null,
    @SerializedName("is_continuous")
    var isContinuous: Boolean? = null,
    @SerializedName("is_endless")
    var isEndless: Boolean? = null,
    @SerializedName("is_startless")
    var isStartless: Boolean? = null,
    @SerializedName("use_place_schedule")
    var usePlaceSchedule: Boolean? = null
)