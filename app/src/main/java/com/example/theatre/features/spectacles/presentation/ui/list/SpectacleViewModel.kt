package com.example.theatre.features.spectacles.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.core.domain.model.Performance
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model для хранения списка событий
 *
 * @author Marianna Sabanchieva
 */

class SpectacleViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private var _spectacleLoaded = MutableLiveData<List<Performance>>()
    val spectacleLoaded: LiveData<List<Performance>> get() = _spectacleLoaded

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            _spectacleLoaded.postValue(getPerformanceUseCase.getPerformance())
        }
    }
}