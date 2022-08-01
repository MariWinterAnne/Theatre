package com.example.theatre.features.poster.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase

/**
 * Вью-модель для фичи афиши
 * todo Разобраться с дата классами афиши
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersViewModel(
    private val getPerformanceUseCase: GetPerformanceUseCase
) : ViewModel() {
//    private val _posterLoaded = MediatorLiveData<List<Performance>>()
//    val posterLoaded: LiveData<List<Performance>> get() = _posterLoaded
//
//    suspend fun init() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _posterLoaded.value = getPerformanceUseCase.getPerformance()
//        }
//    }
}