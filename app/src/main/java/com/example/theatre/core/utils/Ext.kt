package com.example.theatre.core.utils

import android.content.Context
import com.example.theatre.core.domain.models.PerformanceParticipants
import com.example.theatre.features.info.presentation.ui.detail.toRole

/**
 * Функции установки значения по умолчанию
 *
 * @author Marianne Sabanchieva
 */

fun Int?.orDefault(value: Int = -1) = this ?: value
fun Long?.orLongDefault(value: Long = -1) = this ?: value

/**
 * Функция формирует многострочный список актеров, задействованных в постановке
 *
 * @author Marianne Sabanchieva
 */

fun List<PerformanceParticipants>.toListOfActorsInPerformance(context: Context): String {
    val participantsList = StringBuilder()
    for (actor in this) {
        val role = context.getString(actor.role?.slug.orEmpty().toRole())
        val partList = actor.agentModel?.title.orEmpty()
        participantsList.appendLine("$partList, $role")
    }
    return participantsList.toString()
}