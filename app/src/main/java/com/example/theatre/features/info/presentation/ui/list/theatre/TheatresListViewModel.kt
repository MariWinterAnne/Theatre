package com.example.theatre.features.info.presentation.ui.list.theatre

import GetTheatreUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState

/**
 * View model для хранения списка театров
 *
 * @author Tamerlan Mamukhov
 */

class TheatresListViewModel(
    private val getTheatreUseCase: GetTheatreUseCase
) : ViewModel() {
    private val _theatresContent = MutableLiveData<ContentResultState>()
    val theatresContent get() = _theatresContent

    fun getTheatres() = viewModelCall(
        call = { getTheatreUseCase.getTheatre() },
        contentResultState = _theatresContent
    )


}