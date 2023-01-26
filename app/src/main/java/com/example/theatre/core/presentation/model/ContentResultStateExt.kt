package com.example.theatre.core.presentation.model

/**
 * Функция для удобной работы с готовым [ContentResultState] в фрагментах
 *
 * @param onStateSuccess        действие при успехе
 * @param onStateError          действие при неудаче
 * @author Tamerlan Mamukhov on 2023-01-07
 */
fun ContentResultState.handleContents(
    onStateSuccess: (content: Any?) -> Unit,
    onStateError: (error: ErrorModel) -> Unit
) = when (this) {
    is ContentResultState.Content -> {
        onStateSuccess.invoke(this.content)
    }
    is ContentResultState.Error -> {
        onStateError.invoke(this.error)
    }
    else -> {}
}
