package com.example.theatre.core.presentation.utils

import android.content.Context
import com.example.theatre.core.data.model.PerformanceDates
import com.example.theatre.core.data.model.PerformanceParticipants
import com.example.theatre.core.presentation.utils.Default.orDefault
import com.example.theatre.features.info.presentation.ui.detail.toRole

/**
 * Функции для формирования многострочных данных для последующего отображения
 *
 * @author Marianne Sabanchieva
 */

fun getUpcomingPerformanceDates(dates: ArrayList<PerformanceDates>): StringBuilder {
    val datesList = StringBuilder()
    for (date in dates) {
        datesList.appendLine(getUpcomingPerformanceDateLine(date.start.orDefault(), date.end.orDefault()))
    }
    return datesList
}

fun getPersonsActingInPerformance(actors: ArrayList<PerformanceParticipants>, mContext: Context?): StringBuilder {
    val participantsList = StringBuilder()
    for (actor in actors) {
        val role = mContext?.getString(actor.role?.slug.orEmpty().toRole())
        val partList = actor.agent_model?.title.orEmpty()
        participantsList.appendLine("$partList, $role")
    }
    return participantsList
}