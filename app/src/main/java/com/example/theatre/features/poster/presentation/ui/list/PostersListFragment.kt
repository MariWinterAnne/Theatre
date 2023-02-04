package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.theatre.R
import com.example.theatre.core.presentation.model.ContentResultState
import com.example.theatre.core.presentation.model.handleContents
import com.example.theatre.databinding.FragmentPosterBinding
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.presentation.adapters.PosterBriefItemAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком афиш
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PostersListFragment : Fragment() {

    private lateinit var adapter: PosterBriefItemAdapter
    private lateinit var binding: FragmentPosterBinding
    private val viewModel by viewModel<PostersListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PosterBriefItemAdapter { id: Int ->
            onItemClicked(id)
        }

        viewModel.getPosters()

        initObservers()

    }

    private fun onItemClicked(id: Int) {
        val bundle = bundleOf("poster_id" to id)
        findNavController()
            .navigate(R.id.action_home_to_posterDetailFragment, bundle)
    }

    private fun initObservers() {
        viewModel.postersBrief.observe(viewLifecycleOwner, ::handlePosters)
    }


    private fun handlePosters(contentResultState: ContentResultState) =
        contentResultState.handleContents(
            onStateSuccess = {
                adapter.setData(it as List<PosterBriefItem>)
                binding.rvPosters.adapter = adapter
            },
            onStateError = {

            }
        )

}