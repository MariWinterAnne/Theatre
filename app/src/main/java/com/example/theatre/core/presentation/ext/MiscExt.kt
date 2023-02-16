package com.example.theatre.core.presentation.ext

import android.content.Context
import android.os.Build
import android.text.Html
import androidx.core.text.HtmlCompat
import com.example.theatre.core.domain.model.common.agent.AgentParticipations
import com.example.theatre.core.domain.model.common.performance.PerformanceParticipants

fun String.filterHtmlEncodedText(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(replace("\n", "<br>"), Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(replace("\n", "<br>")).toString()
    }.apply {
        replace("\\</br.*?>", "\\\n")
    }

}

fun String.deleteHTML(): String =
    if (this.isEmpty()) String.EMPTY else "${
        HtmlCompat.fromHtml(
            this,
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
    }"

val String.Companion.EMPTY: String
    get() = ""

/**
 * Функции установки значения по умолчанию
 *
 * @author Tamerlan Mamukhov
 */
fun Int?.orDefault(value: Int = -1) = this ?: value
fun Long?.orLongDefault(value: Long = -1) = this ?: value

/**
 * Функция формирует многострочный список актеров, задействованных в постановке
 *
 * @author Tamerlan Mamukhov
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

/**
 * Функция формирует многострочный список постановок, в которых задействован актер
 *
 * @author Tamerlan Mamukhov
 */

fun List<AgentParticipations>.toListOfPerformances(context: Context): String {
    val performancesList = StringBuilder()
    for (performance in this) {
        val role = context.getString(performance.role?.slug.orEmpty().toRole())
        val partList = performance.item?.title.orEmpty().replaceFirstChar { it.uppercaseChar() }
        performancesList.appendLine("$partList, $role")
    }
    return performancesList.toString()
}
