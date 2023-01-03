package com.example.theatre.core.domain.error

import androidx.annotation.StringRes

data class ErrorModel(@StringRes val title: Int, @StringRes val description: Int)
