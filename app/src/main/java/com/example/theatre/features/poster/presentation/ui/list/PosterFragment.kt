package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPosterBinding
import com.example.theatre.features.poster.domain.model.PosterBriefItem
import com.example.theatre.features.poster.domain.model.PosterDetails
import com.example.theatre.features.poster.presentation.adapters.PosterBriefItemAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Фрагмент со списком афиш
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterFragment : Fragment() {

    private lateinit var adapter: PosterBriefItemAdapter
    private lateinit var binding: FragmentPosterBinding
    private val viewModel by viewModel<PostersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postersList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        adapter = PosterBriefItemAdapter {
            id: Int -> onItemClicked(id)
        }

        binding.postersList.adapter = adapter

        binding.postersList.animation =
            AnimationUtils.loadAnimation(binding.postersList.context, R.anim.amination_poster)

        initObservers()

        viewModel.getPosters()
    }

    private fun onItemClicked(id: Int) {
        val bundle = bundleOf("poster_id" to id)
        findNavController()
            .navigate(R.id.action_home_to_posterDetailFragment, bundle)
    }

    private fun initObservers() {
        viewModel.postersBrief.observe(viewLifecycleOwner, ::setData)
    }


    private fun setData(list: List<PosterBriefItem>) {
        adapter.setData(list)
    }

}