package com.example.theatre.core.utils

/**
 * Функции установки значения по умолчанию
 *
 * @author Marianne Sabanchieva
 */

fun Int?.orDefault(value: Int = -1) = this ?: value