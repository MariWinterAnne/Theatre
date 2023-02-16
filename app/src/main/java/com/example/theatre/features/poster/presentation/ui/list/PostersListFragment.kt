package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theatre.R
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.core.presentation.model.refreshPage
import com.example.theatre.core.presentation.ui.LayoutErrorHandler
import com.example.theatre.core.presentation.ui.ViewBindingFragment
import com.example.theatre.databinding.FragmentPosterBinding
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.presentation.adapters.PosterBriefItemAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком афиш
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersListFragment : ViewBindingFragment<FragmentPosterBinding>() {

    private lateinit var adapter: PosterBriefItemAdapter
    private val viewModel by viewModel<PostersListViewModel>()
    private val layoutErrorHandler by inject<LayoutErrorHandler>()

    override val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> FragmentPosterBinding
        get() = FragmentPosterBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        viewModel.getPosters()
        prepareAdapter()
    }

    private fun onItemClicked(id: Int) =
        findNavController()
            .navigate(R.id.action_home_to_posterDetailFragment, bundleOf("poster_id" to id))

    private fun prepareAdapter() {
        nonNullBinding.rvPosters.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        adapter = PosterBriefItemAdapter { id: Int ->
            onItemClicked(id)
        }
    }

    private fun initObservers() {
        viewModel.postersBrief.observe(viewLifecycleOwner, ::handlePosters)
    }


    private fun handlePosters(contentResultState: ContentResultState) {
        contentResultState.refreshPage(
            nonNullBinding.rvPosters, nonNullBinding.progressBar, nonNullBinding.errorLayout
        )
        contentResultState.handleContents(
            onStateSuccess = {
                adapter.setData(it as List<PosterBriefItem>)
                nonNullBinding.rvPosters.adapter = adapter
            },
            onStateError = {
                withSafeBinding {
                    layoutErrorHandler.handleLayout(this.errorLayout, {}, it, this.rvPosters)
                }
            }
        )
    }
}