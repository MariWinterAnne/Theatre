package com.example.theatre.features.info.presentation.ui.detail.theatre

import GetTheatreUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState

/**
 * View model для хранения детальных данных о театре
 *
 * @author Marianna Sabanchieva
 */

class TheatreDetailViewModel(
    private val getTheatreUseCase: GetTheatreUseCase
) : ViewModel() {
    private val _theatreDetailsContent = MutableLiveData<ContentResultState>()
    val theatreDetailsContent get() = _theatreDetailsContent

    private val _cityContent = MutableLiveData<ContentResultState>()
    val cityContent get() = _cityContent

    fun getTheatreById(id: Int) {
        viewModelCall(
            call = { getTheatreUseCase.getTheatreById(id) },
            contentResultState = _theatreDetailsContent
        )
//
//        if ((_theatreDetailsContent as Theatre).location != null) {
//            viewModelCall(
//                call = { getTheatreUseCase.getCityName((_theatreDetailsContent as Theatre).location.orEmpty()) },
//                contentResultState = _cityContent
//            )
//        }
    }
}