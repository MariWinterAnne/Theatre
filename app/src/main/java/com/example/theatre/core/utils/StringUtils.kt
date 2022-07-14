package com.example.theatre.core.utils

import androidx.core.text.HtmlCompat

/**
 * Delete html - функция обработки тегов
 *
 * @author Marianne Sabanchieva
 */

object StringUtils {
    fun String.deleteHTML(): String =
        if (this.isEmpty()) String.EMPTY else "${HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)}"

    val String.Companion.EMPTY: String
        get() = ""
}