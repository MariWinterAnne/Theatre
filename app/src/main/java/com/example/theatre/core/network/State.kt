package com.example.theatre.core.network

sealed class State<out T> {
    data class Success<out T>(val data: T) : State<T>()
    data class Error(
        val cause: HttpResult,
        val code : Int? = null,
        val errorMessage : String? = null
    ) : State<Nothing>()
}
