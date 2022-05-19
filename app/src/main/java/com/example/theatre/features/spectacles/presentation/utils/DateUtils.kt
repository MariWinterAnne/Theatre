package com.example.theatre.features.spectacles.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val format = "dd.MM.yyyy"
    private const val format2 = "HH:mm"

    fun convertLongToTime(startDay: Int, endDay: Int): String {
        val date = Date(startDay.toLong()*1000)
        val date2 = Date(endDay.toLong()*1000)
        val format = SimpleDateFormat(format)
        val format2 = SimpleDateFormat(format2)
        return "${format.format(date)} - ${format.format(date2)}, ${format2.format(date)}"
    }

    fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }
}