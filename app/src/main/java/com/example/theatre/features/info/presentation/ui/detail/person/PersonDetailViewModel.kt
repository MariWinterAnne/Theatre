package com.example.theatre.features.info.presentation.ui.detail.person

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase

/**
 * View model для хранения детальных данных об актере
 *
 * @author Tamerlan Mamukhov
 */

class PersonDetailViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {
    private val _personDetailsMutableLiveData = MutableLiveData<ContentResultState>()
    val personDetails get() = _personDetailsMutableLiveData

    fun getPersonById(id: Int) =
        viewModelCall(
            call = { getPersonUseCase.getPersonById(id) },
            contentResultState = _personDetailsMutableLiveData
        )
}