package com.example.theatre.features.spectacles.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase

/**
 * View model для хранения деталей события
 *
 * @constructor Create empty Spectacle details view model
 */
class SpectacleDetailsViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private val _spectacleDetailLoaded = MutableLiveData<ContentResultState>()
    val spectacleDetailLoaded get() = _spectacleDetailLoaded

    private val _cityLoaded = MutableLiveData<ContentResultState>()
    val cityLoaded get() = _cityLoaded

    private val _placeLoaded = MutableLiveData<ContentResultState>()
    val placeLoaded get() = _placeLoaded

    fun getSpectacleDetails(id: Int) {
        viewModelCall(
            call = { getPerformanceUseCase.getPerformanceById(id) },
            contentResultState = _spectacleDetailLoaded
        )
    }

    fun getCity(slug: String) =
        viewModelCall(
            call = { getPerformanceUseCase.getCityName(slug) },
            contentResultState = _cityLoaded
        )

    fun getPlace(placeId: Int) =
        viewModelCall(
            call = { getPerformanceUseCase.getPlace(placeId) },
            contentResultState = _placeLoaded
        )
}