package com.example.theatre.core.presentation.model

import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.core.presentation.ui.TryAgainAction
import com.example.theatre.databinding.LayoutErrorBinding

typealias SuccessStateAction = (content: Any?) -> Unit
typealias ErrorStateAction = (error: ErrorModel) -> Unit
typealias LoadingStateAction = () -> Unit

/**
 * Функция для удобной работы с готовым [ContentResultState] в фрагментах
 *
 * @param onStateSuccess        действие при успехе
 * @param onStateError          действие при неудаче
 * @author Tamerlan Mamukhov on 2023-01-07
 */
fun ContentResultState.handleContents(
    onStateSuccess: SuccessStateAction,
    onStateError: ErrorStateAction,
    onStateLoading: LoadingStateAction? = null
) = when (this) {
    is ContentResultState.Content -> {
        onStateSuccess.invoke(this.content)
    }
    is ContentResultState.Error -> {
        onStateError.invoke(this.error)
    }
    is ContentResultState.Loading -> {
        onStateLoading?.invoke()
    }
}

fun ContentResultState.refreshPage(
    view: ViewGroup,
    progressBar: ProgressBar,
    errorLayout: LayoutErrorBinding? = null,
    tryAgainAction: TryAgainAction? = null
) {
    view.isVisible = this is ContentResultState.Content
    if (this is ContentResultState.Error) {
        errorLayout?.root?.isVisible = true
        errorLayout?.apply {
            textErrorTitle.setText(this@refreshPage.error.title.toString())
            textErrorDescription.setText(this@refreshPage.error.description.toString())
            btnErrorTryAgain.setOnClickListener {
                tryAgainAction
            }
        }
    }
    progressBar.isVisible = this is ContentResultState.Loading
}