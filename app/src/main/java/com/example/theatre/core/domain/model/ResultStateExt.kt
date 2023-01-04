package com.example.theatre.core.domain.model

import java.net.*

inline fun <T> safeCall(action: () -> T): ResultState<T> {
    return try {
        ResultState.Success(action.invoke())
    } catch (throwable: Throwable) {
        ResultState.Error(throwable.isNetworkException())
    }
}

fun Throwable?.isNetworkException(): Boolean {
    return when (this) {
        is ConnectException,
        is SocketException,
        is SocketTimeoutException,
        is UnknownHostException,
        is ProtocolException,
        -> true
        else -> false
    }
}
