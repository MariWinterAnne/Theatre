package com.example.theatre.features.spectacles.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.core.domain.model.PerformancePlaceLocation
import com.example.theatre.core.domain.model.PerformancePlace
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import com.example.theatre.core.utils.orDefault
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.SupervisorJob

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

    fun init(id: Int) {
        viewModelScope.launch {
            _spectacleDetailLoaded.value =
                withContext(Dispatchers.IO) { getPerformanceUseCase.getPerformanceById(id) }

            if (_spectacleDetailLoaded.value?.location?.slug != null) {
                val jobLocationDeferred = async(Dispatchers.IO + SupervisorJob()) {
                    getPerformanceUseCase.getCityName(_spectacleDetailLoaded.value?.location?.slug.orEmpty())
                }
                _cityLoaded.value = jobLocationDeferred.await()
            }

            if (_spectacleDetailLoaded.value?.place?.id != null) {
                val jobPlaceDeferred = async(Dispatchers.IO + SupervisorJob()) {
                    getPerformanceUseCase.getPlace(_spectacleDetailLoaded.value?.place?.id.orDefault())
                }
                _placeLoaded.value = jobPlaceDeferred.await()
            }
        }
    }
}