package com.example.theatre.core.utils

import com.example.theatre.core.domain.model.PerformanceDates
import com.example.theatre.core.utils.StringUtils.Companion.EMPTY
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Функции для работы с датой
 *
 * @author Marianne Sabanchieva
 */

class PerformanceDateFormatter {
    private fun performanceDateFormat(
        performanceStartDate: Int,
        performanceEndDate: Int
    ): String {
        //приведение к формату "dd.MM.yyyy"
        val dateFormatter = SimpleDateFormat(FORMAT)
        val startDate = dateFormatter.format(Date(performanceStartDate.toLong() * TIME_CONST))
        val endDate = dateFormatter.format(Date(performanceEndDate.toLong() * TIME_CONST))

        //приведение к формату "HH:mm"
        val timeFormatter = SimpleDateFormat(FORMAT2)
        val startTime = timeFormatter.format(Date(performanceStartDate.toLong() * TIME_CONST))
        return "$startDate - $endDate, $startTime"
    }

    private fun getUpcomingPerformanceDateToLine(
        performanceStartDate: Int,
        performanceEndDate: Int
    ): String {
        var formattedDateLine = String.EMPTY
        val startDate = performanceStartDate.toLong() * TIME_CONST
        //исключение уже прошедших сеансов
        if (startDate >= System.currentTimeMillis()) {
            formattedDateLine = performanceDateFormat(performanceStartDate, performanceEndDate)
        }
        return formattedDateLine
    }

    fun getUpcomingPerformanceDates(dates: ArrayList<PerformanceDates>): String {
        val datesList = StringBuilder()
        for (date in dates) {
            if (getUpcomingPerformanceDateToLine(date.start.orDefault(), date.end.orDefault()) != String.EMPTY)
                datesList.appendLine(getUpcomingPerformanceDateToLine(date.start.orDefault(), date.end.orDefault()))
        }
        return datesList.toString()
    }

    companion object{
        private const val FORMAT = "dd.MM.yyyy"
        private const val FORMAT2 = "HH:mm"
        private const val TIME_CONST = 1000
    }
}