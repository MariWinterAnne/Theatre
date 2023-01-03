package com.example.theatre.core.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.core.domain.error.parseError
import com.nightstalker.artic.core.domain.ContentResultState
import com.nightstalker.artic.core.domain.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Функции для работы с [ContentResultState] в вью-моделях
 *
 * @author Tamerlan Mamukhov
 * @created 2022-10-24
 */
suspend fun onResultStateSuccess(
    contentsList: List<Any> = emptyList(),
    contentSingle: Any? = null,
    contentResultState: MutableLiveData<ContentResultState>,
) = withContext(Dispatchers.Main) {
    if (contentsList.isNotEmpty()) {
        contentResultState.postValue(ContentResultState.Content(contentsList = contentsList))
    }
    if (contentSingle != null) {
        contentResultState.postValue(ContentResultState.Content(contentSingle = contentSingle))
    }
}

suspend fun onResultStateError(isNetworkError: Boolean, contentResultState: MutableLiveData<ContentResultState>) =
    withContext(Dispatchers.Main) {
        contentResultState.value = ContentResultState.Error(error = isNetworkError.parseError())
    }

/**
 * Extension функция для [ViewModel]. Позволяет делать вызовы функций (например, получение данных с сети) и
 * поместить результат в [ContentResultState].
 *
 * @param dispatcher            диспетчер корутин
 * @param call                  функция для вызова
 * @param contentResultState    переменная, куда помещается результат работы
 * @author Tamerlan Mamukhov on 2022-11-12
 */
fun ViewModel.viewModelCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    call: suspend () -> Any,
    contentResultState: MutableLiveData<ContentResultState>,
) = viewModelScope.launch(dispatcher) {
    when (val resultState = call.invoke()) {
        is ResultState.Success<*> -> when (resultState.data) {
            is List<*> -> onResultStateSuccess(
                contentsList = resultState.data as List<Any>,
                contentResultState = contentResultState
            )
            else -> onResultStateSuccess(
                contentSingle = resultState.data,
                contentResultState = contentResultState
            )
        }
        is ResultState.Error -> onResultStateError(
            isNetworkError = resultState.errorData,
            contentResultState = contentResultState
        )
    }
}