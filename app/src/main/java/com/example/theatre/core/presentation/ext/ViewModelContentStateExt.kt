package com.example.theatre.core.presentation.ext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.core.domain.model.ResultState
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.parseError
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
    content: Any? = null,
    contentResultState: MutableLiveData<ContentResultState>,
) = withContext(Dispatchers.IO) {
    contentResultState.postValue(ContentResultState.Content(content = content))
}

suspend fun onResultStateError(
    isNetworkError: Boolean,
    contentResultState: MutableLiveData<ContentResultState>
) =
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
    contentResultState: MutableLiveData<ContentResultState>? = null,
) = viewModelScope.launch(dispatcher) {
    when (val resultState = call.invoke()) {
        is ResultState.Success<*> -> contentResultState?.let {
            onResultStateSuccess(
                resultState.data,
                contentResultState = it
            )
        }

        is ResultState.Error -> contentResultState?.let {
            onResultStateError(
                isNetworkError = resultState.errorData,
                contentResultState = it
            )
        }
    }
}