package com.example.theatre.features.info.presentation.ui.utils

import android.content.Context
import com.example.theatre.features.info.domain.model.AgentPerformanceParticipations
import com.example.theatre.features.info.presentation.ui.detail.toRole

/**
 * Функция формирует многострочный список постановок, в которых задействован актер
 *
 * @author Marianne Sabanchieva
 */

fun List<AgentPerformanceParticipations>.toListOfPerformances(context: Context): String {
    val performancesList = StringBuilder()
    for (performance in this) {
        val role = context.getString(performance.role?.slug.orEmpty().toRole())
        val partList = performance.item?.title.orEmpty().replaceFirstChar { it.uppercaseChar() }
        performancesList.appendLine("$partList, $role")
    }
    return performancesList.toString()
}