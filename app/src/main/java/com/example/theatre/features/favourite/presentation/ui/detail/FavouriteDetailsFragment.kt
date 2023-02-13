package com.example.theatre.features.favourite.presentation.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.theatre.databinding.FragmentFavouriteDetailsBinding
import com.example.theatre.core.presentation.ui.ViewBindingFragment

class FavouriteDetailsFragment : ViewBindingFragment<FragmentFavouriteDetailsBinding>() {

    override val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> FragmentFavouriteDetailsBinding
        get() = FragmentFavouriteDetailsBinding::inflate

}