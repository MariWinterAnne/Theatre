package com.example.theatre.core.presentation.utils

import androidx.core.text.HtmlCompat

/**
 * Delete h t m l - функция обработки тегов
 *
 * @author Marianne Sabanchieva
 */

fun String.deleteHTML(): String {
    if (this.isEmpty())
        return String.EMPTY
    return "${HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)}"
}

val String.Companion.EMPTY: String
    get() = ""