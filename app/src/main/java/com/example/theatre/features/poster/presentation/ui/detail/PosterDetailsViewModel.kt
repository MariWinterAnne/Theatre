package com.example.theatre.features.poster.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase

/**
 * ViewModel для получения деталей афиши
 * @author Tamerlan Mamukhov
 * @created 2022-08-27
 */
class PosterDetailsViewModel(
    private val getPosterUseCase: GetPosterUseCase
) : ViewModel() {
    private val _posterDetailedLoaded = MutableLiveData<ContentResultState>()
    val posterDetailedLoaded get() = _posterDetailedLoaded

    fun getPoster(id: Int) = viewModelCall(
        call = { getPosterUseCase.getPosterDetailsById(id) },
        contentResultState = _posterDetailedLoaded
    )
}