package com.example.theatre.features.spectacles.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpectacleViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private val _spectacleLoaded = MutableLiveData<List<Performance>>()
    val spectacleLoaded: LiveData<List<Performance>> get() = _spectacleLoaded

    private val _loading = MutableLiveData<Boolean>()

    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _spectacleLoaded.value = getPerformanceUseCase.getPerformance()
            }
        }
        _loading.value = false
    }

}