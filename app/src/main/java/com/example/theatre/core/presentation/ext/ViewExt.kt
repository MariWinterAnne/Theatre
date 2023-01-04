package com.example.theatre.core.presentation.ext

import android.view.inputmethod.EditorInfo
import android.widget.EditText

/**
 * Фукнции для [View]
 * @author Tamerlan Mamukhov
 */
fun EditText.onDone(callback: (query: String) -> Unit) =
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            if (!text.isNullOrBlank()) {
                callback.invoke(text.trim().toString())
            } else {
                error = ""
            }
            return@setOnEditorActionListener false
        }
        false
    }
