package com.example.theatre.features.spectacles.data.api.model

import com.example.theatre.core.presentation.ext.EMPTY
import com.google.gson.annotations.SerializedName

/**
 * Performance dates - модель для получения списка дат, на которые назначен показ постановки
 *
 * @property startDate - дата начала
 * @property startTime - время начала
 * @property start - дата и время начала
 * @property endDate - дата окончания
 * @property endTime - время окончания
 * @property end - дата и время окончания
 * @property isContinuous - мероприятие продолжительное
 * @property isEndless - мероприятие не имеет времени конца
 * @property isStartles - мероприятие не имеет времени начала
 *
 * @author Tamerlan Mamukhov
 */

data class PerformanceDatesModel(
    @SerializedName("start_date")
    val startDate: String = String.EMPTY,
    @SerializedName("start_time")
    val startTime: String = String.EMPTY,
    @SerializedName("start")
    val start: Long? = 0,
    @SerializedName("end_date")
    val endDate: String = String.EMPTY,
    @SerializedName("end_time")
    val endTime: String = String.EMPTY,
    @SerializedName("end")
    val end: Long? = 0,
    @SerializedName("is_continuous")
    val isContinuous: Boolean? = false,
    @SerializedName("is_endless")
    val isEndless: Boolean? = false,
    @SerializedName("is_startless")
    val isStartles: Boolean? = false
)