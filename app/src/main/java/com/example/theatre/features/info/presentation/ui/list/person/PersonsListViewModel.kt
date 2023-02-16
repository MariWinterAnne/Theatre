package com.example.theatre.features.info.presentation.ui.list.person

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.info.domain.usecases.GetPersonUseCase

/**
 * View model для хранения списка актеров
 *
 * @author Tamerlan Mamukhov
 */

class PersonsListViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : ViewModel() {
    private val _personLoaded = MutableLiveData<ContentResultState>()
    val personLoaded get() = _personLoaded

    fun init() =
        viewModelCall(
            call = { getPersonUseCase.getPerson() },
            contentResultState = _personLoaded
        )

}