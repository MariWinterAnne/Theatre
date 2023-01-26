package com.example.theatre.features.poster.presentation.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase

/**
 * Вью-модель для получения списка афиш
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersViewModel(
    private val getPosterUseCase: GetPosterUseCase
) : ViewModel() {
    private val _postersBriefLoaded = MutableLiveData<ContentResultState>()
    val postersBrief get() = _postersBriefLoaded

    fun getPosters() = viewModelCall(
        call = { getPosterUseCase.getPosters() },
        contentResultState = _postersBriefLoaded
    )

}