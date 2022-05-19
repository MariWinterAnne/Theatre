package com.example.theatre.features.info.presentation.ui.list.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {
    private val _personLoaded = MutableLiveData<List<Agent>>()
    val personLoaded: LiveData<List<Agent>> get() = _personLoaded

    private val _loading = MutableLiveData<Boolean>()
    suspend fun init() {
        _loading.value = true
        withContext(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _personLoaded.value =
                    getPersonUseCase.getPerson()
            }
        }
        _loading.value = false
    }
}