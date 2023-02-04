package com.example.theatre.core.presentation.ext

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

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

/**
 * Выполняет функции при не/пустом адаптере
 *
 * @param onAdapterEmpty        действие при пустом адаптере
 * @param onAdapterNotEmpty     действие при непустом адаптере
 */
fun RecyclerView.Adapter<RecyclerView.ViewHolder>.handleErrorMessage(
    onAdapterEmpty: () -> Unit,
    onAdapterNotEmpty: () -> Unit
) =
    when (this.itemCount) {
        0 -> onAdapterEmpty.invoke()
        else -> onAdapterNotEmpty.invoke()
    }
