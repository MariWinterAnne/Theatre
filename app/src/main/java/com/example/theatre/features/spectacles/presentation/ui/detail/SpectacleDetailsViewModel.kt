package com.example.theatre.features.spectacles.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.core.data.model.PerformancePlace
import com.example.theatre.core.data.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import com.example.theatre.core.presentation.utils.Default.orDefault
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * View model для хранения деталей события
 *
 * @constructor Create empty Spectacle details view model
 */

class SpectacleDetailsViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private val _spectacleDetailLoaded = MutableLiveData<Performance>()
    val spectacleDetailLoaded: LiveData<Performance> get() = _spectacleDetailLoaded

    private val _cityLoaded = MutableLiveData<PerformancePlaceLocation>()
    val cityLoaded: LiveData<PerformancePlaceLocation> get() = _cityLoaded

    private val _placeLoaded = MutableLiveData<PerformancePlace>()
    val placeLoaded: LiveData<PerformancePlace> get() = _placeLoaded

    private val _loading = MutableLiveData<Boolean>()

    fun init(id: Int) {
        _loading.value = true
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _spectacleDetailLoaded.value = getPerformanceUseCase.getPerformanceById(id)
                _cityLoaded.value = _spectacleDetailLoaded.value?.location?.slug.orEmpty().let { getPerformanceUseCase.getCityName(it) }
                _placeLoaded.value = _spectacleDetailLoaded.value?.place?.id.orDefault().let { getPerformanceUseCase.getPlaceById(it) }
            }
        }
        _loading.value = false
    }
}