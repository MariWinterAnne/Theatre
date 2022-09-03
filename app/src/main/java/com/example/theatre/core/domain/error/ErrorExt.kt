package com.example.theatre.core.domain.error

import com.example.theatre.R

fun Boolean.parseError(): ErrorModel =
    if (this) ErrorModel(
        R.string.network_error_title,
        R.string.network_error_description,
    ) else ErrorModel(
        R.string.loading_error_title,
        R.string.loading_error_description,
    )