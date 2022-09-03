package com.example.theatre.core.presentation

import android.os.Build
import android.text.Html
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.example.theatre.R

/**
 * @author Tamerlan Mamukhov
 * @created 2022-11-21
 */
fun EditText.onDone(callback: (query: String) -> Unit) = setOnEditorActionListener { _, actionId, _ ->
    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
        if (!text.isNullOrBlank()) {
            callback.invoke(text.trim().toString())
        }
        else {
            error = ""
        }
        return@setOnEditorActionListener false
    }
    false
}

fun String.filterHtmlEncodedText(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(replace("\n", "<br>"), Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(replace("\n", "<br>")).toString()
    }.apply {
        replace("\\</br.*?>", "\\\n")
    }
}
