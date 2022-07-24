package com.example.theatre.features.info.presentation.ui.list.theatre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model для хранения списка театров
 *
 * @author Marianna Sabanchieva
 */

class TheatreViewModel(
    private val getTheatreUseCase: GetTheatreUseCase
) : ViewModel() {
    private val _theatreLoaded = MutableLiveData<List<Theatre>>()
    val theatreLoaded: LiveData<List<Theatre>> get() = _theatreLoaded

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            _theatreLoaded.postValue(getTheatreUseCase.getTheatre())
        }
    }
}