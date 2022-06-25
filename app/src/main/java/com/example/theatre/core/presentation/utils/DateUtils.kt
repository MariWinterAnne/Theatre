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

object DateUtils {
    private fun convertLongToTime(startDay: Int, endDay: Int): String {
        val date = Date(startDay.toLong() * TIME_CONST)
        val date2 = Date(endDay.toLong() * TIME_CONST)
        val format = SimpleDateFormat(FORMAT)
        val format2 = SimpleDateFormat(FORMAT2)
        return "${format.format(date)} - ${format.format(date2)}, ${format2.format(date)}"
    }

    private fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }

    fun convertIntToStringBuilder(startDay: Int, endDay: Int): String {
        var l = String.EMPTY
        val startDate = startDay.toLong() * TIME_CONST
        if (startDate >= currentTimeToLong()) {
            l = convertLongToTime(startDay, endDay)
        }
        return l
    }
}