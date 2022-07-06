package com.example.theatre.core.presentation.utils

import com.example.theatre.network.Constants.FORMAT
import com.example.theatre.network.Constants.FORMAT2
import com.example.theatre.network.Constants.TIME_CONST
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Функции для работы с датой
 *
 * @author Marianne Sabanchieva
 */

private fun performanceDateFormatter(performanceStartDate: Int, performanceEndDate: Int): String {
    //приведение к формату "dd.MM.yyyy"
    val dateFormatter = SimpleDateFormat(FORMAT)
    val startDate = dateFormatter.format(Date(performanceStartDate.toLong() * TIME_CONST))
    val endDate = dateFormatter.format(Date(performanceEndDate.toLong() * TIME_CONST))

    //приведение к формату "HH:mm"
    val timeFormatter = SimpleDateFormat(FORMAT2)
    val startTime = timeFormatter.format(Date(performanceStartDate.toLong() * TIME_CONST))
    return "$startDate - $endDate, $startTime"
}

fun getUpcomingPerformanceDateLine(performanceStartDate: Int, performanceEndDate: Int): String {
    var formattedDateLine = String.EMPTY
    val startDate = performanceStartDate.toLong() * TIME_CONST
    //исключение уже прошедших сеансов
    if (startDate >= System.currentTimeMillis()) {
        formattedDateLine = performanceDateFormatter(performanceStartDate, performanceEndDate)
    }
    return formattedDateLine
}