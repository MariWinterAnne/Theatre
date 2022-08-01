package com.example.theatre.features.poster.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.poster.data.mappers.toPosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Вью-модель для фичи афиши
 * todo Разобраться с дата классами афиши
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersViewModel(
//    private val getPerformanceUseCase: GetPerformanceUseCase
    private val getPosterUseCase: GetPosterUseCase
) : ViewModel() {
    private var _postersBriefLoaded = MutableLiveData<List<PosterBriefItem>>()
    val postersBrief: LiveData<List<PosterBriefItem>> get() = _postersBriefLoaded

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            _postersBriefLoaded.postValue(
                getPosterUseCase.getPosters()
            )
//                getPerformanceUseCase.getPerformance().map { it.toPosterBriefItem() })
        }
    }
}