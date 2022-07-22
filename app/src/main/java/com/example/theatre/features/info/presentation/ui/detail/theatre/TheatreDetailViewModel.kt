package com.example.theatre.features.info.presentation.ui.detail.theatre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.info.domain.model.TheatreLocation
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * View model для хранения детальных данных о театре
 *
 * @author Marianna Sabanchieva
 */

class TheatreDetailViewModel(
    private val getTheatreUseCase: GetTheatreUseCase
) : ViewModel() {
    private val _theatreDetailsMutableLiveData = MutableLiveData<Theatre>()
    val theatreDetails: LiveData<Theatre> get() = _theatreDetailsMutableLiveData

    private val _cityLoaded = MutableLiveData<TheatreLocation>()
    val cityLoaded: LiveData<TheatreLocation> get() = _cityLoaded

    fun getTheatreById(id: Int) {
        viewModelScope.launch {
            _theatreDetailsMutableLiveData.value =
                withContext(Dispatchers.IO) { getTheatreUseCase.getTheatreById(id) }

            if (_theatreDetailsMutableLiveData.value?.location != null) {
                val jobLocationDeferred = async(Dispatchers.IO + SupervisorJob()) {
                    getTheatreUseCase.getCityName(_theatreDetailsMutableLiveData.value?.location.orEmpty())
                }
                _cityLoaded.value = jobLocationDeferred.await()
            }
        }
    }
}