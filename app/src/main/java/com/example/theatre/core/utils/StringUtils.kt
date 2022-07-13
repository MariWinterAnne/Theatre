package com.example.theatre.core.utils

import android.content.Context
import androidx.core.text.HtmlCompat
import com.example.theatre.core.domain.model.PerformanceParticipants
import com.example.theatre.features.info.presentation.ui.detail.toRole

class StringUtils {
    /**
     * Delete h t m l - функция обработки тегов
     *
     * @author Marianne Sabanchieva
     */

    companion object {
        fun String.deleteHTML(): String =
            if (this.isEmpty()) String.EMPTY else "${HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)}"

        val String.Companion.EMPTY: String
            get() = ""
    }

    /**
     * Функция для формирования многострочных данных для последующего отображения
     *
     * @author Marianne Sabanchieva
     */

    fun getPersonsActingInPerformance(actors: ArrayList<PerformanceParticipants>, mContext: Context): StringBuilder {
        val participantsList = StringBuilder()
        for (actor in actors) {
            val role = mContext.getString(actor.role?.slug.orEmpty().toRole())
            val partList = actor.agent_model?.title.orEmpty()
            participantsList.appendLine("$partList, $role")
        }
        return participantsList
    }
}