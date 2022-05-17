package com.example.theatre.features.info.presentation.ui.list.theatre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.features.info.domain.model.Theatre
import com.example.theatre.features.info.domain.usecases.GetTheatreUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TheatreViewModel(
    private val getTheatreUseCase: GetTheatreUseCase
) : ViewModel() {
    private val _theatreLoaded = MutableLiveData<List<Theatre>>()
    val theatreLoaded: LiveData<List<Theatre>> get() = _theatreLoaded

    private val _loading = MutableLiveData<Boolean>()
    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _theatreLoaded.value =
                    getTheatreUseCase.getTheatre()
            }
        }
        _loading.value = false
    }
}