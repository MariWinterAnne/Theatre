package com.example.theatre.features.poster.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.poster.data.mappers.toPosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase
import com.example.theatre.features.spectacles.domain.usecases.GetPerformanceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Вью-модель для фичи афиши
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersViewModel(
    private val getPosterUseCase: GetPosterUseCase
) : ViewModel() {
    private var _postersBriefLoaded = MutableLiveData<List<PosterBriefItem>>()
    val postersBrief: LiveData<List<PosterBriefItem>> get() = _postersBriefLoaded

    private var _posterDetails = MutableLiveData<PosterDetails>()
    val posterDetails: LiveData<PosterDetails> get() = _posterDetails

    fun getPosters() {
        viewModelScope.launch(Dispatchers.IO) {
            _postersBriefLoaded.postValue(
                getPosterUseCase.getPosters()
            )
        }
    }

    fun getPosterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _posterDetails.postValue(
                getPosterUseCase.getPosterDetailsById(id)
            )
        }
    }


}