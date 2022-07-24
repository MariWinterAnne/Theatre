package com.example.theatre.features.info.presentation.ui.list.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theatre.features.info.domain.model.Agent
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model для хранения списка актеров
 *
 * @author Marianna Sabanchieva
 */

class PersonViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {
    private val _personLoaded = MutableLiveData<List<Agent>>()
    val personLoaded: LiveData<List<Agent>> get() = _personLoaded

    fun init(){
        viewModelScope.launch(Dispatchers.IO) {
            _personLoaded.postValue(getPersonUseCase.getPerson())
        }
    }
}