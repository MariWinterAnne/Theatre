package com.example.theatre.core.data.model

import com.google.gson.annotations.SerializedName

/**
 * Performance dates - модель для получения списка дат, на которые назначен показ постановки
 *
 * @property start_date - дата начала
 * @property start_time - время начала
 * @property start - дата и время начала
 * @property end_date - дата окончания
 * @property end_time - время окончания
 * @property end - дата и время окончания
 * @property is_continuous - мероприятие продолжительное
 * @property is_endless - мероприятие не имеет времени конца
 * @property is_startless - мероприятие не имеет времени начала
 *
 * @author Marianna Sabanchieva
 */

data class PerformanceDatesModel(
    @SerializedName("start_date")
    val start_date: String? = null,
    @SerializedName("start_time")
    val start_time: String? = null,
    @SerializedName("start")
    val start: Long? = null,
    @SerializedName("end_date")
    val end_date: String? = null,
    @SerializedName("end_time")
    val end_time: String? = null,
    @SerializedName("end")
    val end: Long? = null,
    @SerializedName("is_continuous")
    val is_continuous: Boolean? = null,
    @SerializedName("is_endless")
    val is_endless: Boolean? = null,
    @SerializedName("is_startless")
    val is_startless: Boolean? = null
)