package com.example.theatre.features.info.presentation.ui.detail.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * View model для хранения детальных данных об актере
 *
 * @author Marianna Sabanchieva
 */

class PersonDetailViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {
    private val _personDetailsMutableLiveData = MutableLiveData<Agent>()
    val personDetails: LiveData<Agent> get() = _personDetailsMutableLiveData

    fun getPersonById(id: Int){
        viewModelScope.launch {
            _personDetailsMutableLiveData.value =
                withContext(Dispatchers.IO) { getPersonUseCase.getPersonById(id) }
        }
    }
}