package com.example.theatre.features.favourite.presentation.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.core.presentation.ext.handleErrorMessage
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.ErrorModel
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.ui.LayoutErrorHandler
import com.example.theatre.core.presentation.ui.ViewBindingFragment
import com.example.theatre.databinding.FragmentFavoriteBinding
import com.example.theatre.features.favourite.domain.model.FavouriteStuff
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент для показа списка избранных афиш
 *
 * @constructor Create empty Favorites list fragment
 */
class FavoritesListFragment : ViewBindingFragment<FragmentFavoriteBinding>() {

    private val favouriteListViewModel by viewModel<FavouriteListViewModel>()
    private val layoutErrorHandler by inject<LayoutErrorHandler>()
    private lateinit var adapter: FavouritesListAdapter

    override val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> FragmentFavoriteBinding
        get() = FragmentFavoriteBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        handleAdapter()
    }

    private fun handleAdapter() {
        adapter = FavouritesListAdapter { }
        adapter.setFavourites(
            listOf(
                FavouriteStuff(1), FavouriteStuff(2)
            )
        )
        this.nonNullBinding.rvFavourites.adapter = adapter
    }

    private fun initObserver() {
        favouriteListViewModel.favouriteContent.observe(viewLifecycleOwner, ::handleFavourites)
    }

    private fun handleFavourites(contentResultState: ContentResultState) =
        contentResultState.handleContents(
            onStateSuccess = {

            },
            onStateError = {
                Log.d("Favolist", "handleFavourites: ${it}")
                with(nonNullBinding) {
                    layoutErrorHandler.handleLayout(
                        this.errorLayout,
                        { },
                        ErrorModel(R.string.closed, R.string.loading_error_description),
                        this.rvFavourites
                    )
                }
            }
        )


}