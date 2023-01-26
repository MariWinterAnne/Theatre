package com.example.theatre.features.favourite.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.favourite.domain.usecase.FavouritesUseCase

class FavouriteDetailsViewModel(
    private val useCase: FavouritesUseCase
) : ViewModel() {

    private var _favouritesContent = MutableLiveData<ContentResultState>()
    val favouritesContent get() = _favouritesContent

    fun getAllFavourites() = viewModelCall(
        call = { useCase.getAll() },
        contentResultState = _favouritesContent
    )
}