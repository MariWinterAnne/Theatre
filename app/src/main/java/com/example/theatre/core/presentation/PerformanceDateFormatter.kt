package com.example.theatre.core.presentation

import com.example.theatre.core.domain.model.common.performance.PerformanceDates
import com.example.theatre.core.presentation.ext.EMPTY
import com.example.theatre.core.presentation.ext.orLongDefault
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Функции для работы с датой
 *
 * @author Tamerlan Mamukhov
 */
class PerformanceDateFormatter {
    private fun performanceDateFormat(
        performanceStartDate: Long,
        performanceEndDate: Long
    ): String {
        //приведение к формату "dd.MM.yyyy"
        val dateFormatter = SimpleDateFormat(DAY_MONTH_YEAR_FORMAT)
        val startDate = dateFormatter.format(Date(performanceStartDate * LONG_TO_MILLISECONDS))
        val endDate = dateFormatter.format(Date(performanceEndDate * LONG_TO_MILLISECONDS))

        //приведение к формату "HH:mm"
        val timeFormatter = SimpleDateFormat(HOURS_MINUTES_FORMAT)
        val startTime = timeFormatter.format(Date(performanceStartDate * LONG_TO_MILLISECONDS))
        return "$startDate - $endDate, $startTime"
    }

    private fun getUpcomingPerformanceDateToLine(
        performanceStartDate: Long,
        performanceEndDate: Long
    ): String {
        var formattedDateLine = String.EMPTY
        val startDate = performanceStartDate * LONG_TO_MILLISECONDS
        //исключение уже прошедших сеансов
        if (startDate >= System.currentTimeMillis()) {
            formattedDateLine = performanceDateFormat(performanceStartDate, performanceEndDate)
        }
        return formattedDateLine
    }

    fun getUpcomingPerformanceDates(dates: List<PerformanceDates>?): String {
        val datesList = StringBuilder()
        if (dates != null) {
            for (date in dates) {
                if (getUpcomingPerformanceDateToLine(
                        date.start.orLongDefault(),
                        date.end.orLongDefault()
                    ) != String.EMPTY
                )
                    datesList.appendLine(
                        getUpcomingPerformanceDateToLine(
                            date.start.orLongDefault(),
                            date.end.orLongDefault()
                        )
                    )
            }
        }
        return datesList.toString()
    }

    companion object {
        private const val DAY_MONTH_YEAR_FORMAT = "dd.MM.yyyy"
        private const val HOURS_MINUTES_FORMAT = "HH:mm"
        private const val LONG_TO_MILLISECONDS = 1000
    }
}