package com.example.theatre.features.poster.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.domain.usecases.GetPosterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel для получения деталей постановки
 * @author Tamerlan Mamukhov
 * @created 2022-08-27
 */
class PosterDetailsViewModel(
    private val getPosterUseCase: GetPosterUseCase
) : ViewModel() {
    private val _posterDetailedLoaded = MutableLiveData<PosterDetails>()
    val posterDetailedLoaded: MutableLiveData<PosterDetails> get() = _posterDetailedLoaded

    fun init(id: Int) =
        viewModelScope.launch {
            _posterDetailedLoaded.value =
                getPosterUseCase.getPosterDetailsById(id)

        }
}