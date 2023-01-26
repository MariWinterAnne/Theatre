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

    fun init(id: Int) {

        viewModelCall(
            call = { getPerformanceUseCase.getPerformanceById(id) },
            contentResultState = _spectacleDetailLoaded
        )

//        val slug = (_spectacleDetailLoaded.value as Performance).location?.slug!!
//        if (slug != null) {
//            viewModelCall(
//                call = { getPerformanceUseCase.getCityName(slug) },
//                contentResultState = _cityLoaded
//            )
//        }
//
//        val place = (_spectacleDetailLoaded.value as Performance).place?.id
//        if (place != null) {
//            viewModelCall(
//                call = { getPerformanceUseCase.getPlace(place) },
//                contentResultState = _placeLoaded
//            )
//        }

    }
}