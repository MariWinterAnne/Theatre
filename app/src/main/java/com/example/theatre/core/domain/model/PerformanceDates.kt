package com.example.theatre.core.domain.model

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

data class PerformanceDates(
    val start_date: String?,
    val start_time: String?,
    val start: Long?,
    val end_date: String?,
    val end_time: String?,
    val end: Long?,
    val is_continuous: Boolean?,
    val is_endless: Boolean?,
    val is_startless: Boolean?
)