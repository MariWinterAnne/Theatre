package com.nightstalker.artic.core.domain

import com.example.theatre.core.domain.error.ErrorModel

/**
 * Класс состояния содержимого
 * @author Tamerlan Mamukhov
 * @created 2022-10-19
 */
sealed class ContentResultState {
    object Loading : ContentResultState()
    data class Error(val error: ErrorModel) : ContentResultState()
    data class Content(var contentsList: List<out Any> = emptyList(), var contentSingle: Any? = null) :
        ContentResultState()
}