package com.example.theatre.core.presentation.utils

/**
 * Функции установки значения по умолчанию
 *
 * @author Marianne Sabanchieva
 */

object Default {
    fun Int?.orDefault(value: Int = -1) = this ?: value
}