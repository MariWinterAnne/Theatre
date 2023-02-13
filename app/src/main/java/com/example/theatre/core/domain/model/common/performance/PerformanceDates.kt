package com.example.theatre.core.domain.model.common.performance

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

data class PerformanceDates(
    val startDate: String?,
    val startTime: String?,
    val start: Long?,
    val endDate: String?,
    val endTime: String?,
    val end: Long?,
    val isContinuous: Boolean?,
    val isEndless: Boolean?,
    val isStartles: Boolean?
)