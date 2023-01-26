package com.example.theatre.features.spectacles.presentation.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase

/**
 * View model для хранения списка событий
 *
 * @author Marianna Sabanchieva
 */

class SpectacleViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private val _spectacleLoaded = MutableLiveData<ContentResultState>()
    val spectacleLoaded get() = _spectacleLoaded

    fun init() = viewModelCall(
        call = { getPerformanceUseCase.getPerformance() },
        contentResultState = _spectacleLoaded
    )

}