package com.example.theatre.features.favourite.presentation.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theatre.core.presentation.ext.viewModelCall
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.features.favourite.domain.model.FavouriteStuff
import com.example.theatre.features.favourite.domain.usecase.FavouritesUseCase

class FavouriteListViewModel(
    private val useCase: FavouritesUseCase
) : ViewModel() {

    private var _favouriteContent = MutableLiveData<ContentResultState>()
    val favouriteContent get() = _favouriteContent

    fun getFavourite(id: Int) =
        viewModelCall(
            call = {
                useCase.getById(id)
            },
            contentResultState = _favouriteContent
        )

    fun deleteFav(fav: FavouriteStuff) =
        viewModelCall(call = { useCase.delete(fav) })


    fun saveFav(fav: FavouriteStuff) =
        viewModelCall(call = { useCase.insert(fav) })

}