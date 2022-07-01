package com.example.theatre.features.poster.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.features.spectacles.domain.model.Performance
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Вью-модель для фичи афиши
 * todo Разобраться с дата классами афиши
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
    private val _posterLoaded = MediatorLiveData<List<Performance>>()
    val posterLoaded: LiveData<List<Performance>> get() = _posterLoaded

    private val _loading = MutableLiveData<Boolean>()

    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                _posterLoaded.value = getPerformanceUseCase.getPerformance()
            }
        }
    }
}