package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPosterListBinding
import com.example.theatre.features.poster.presentation.adapters.PostersListAdapter

/**
 * Фрагмент с ViewPager2 для отображения фраментов с кратким описанием постановок [PosterBriefInfoFragment]
 * @author Tamerlan Mamukhov on 2022-06-26
 */
class PosterListFragment : Fragment() {
    private lateinit var binding: FragmentPosterListBinding
    private lateinit var postersBriefAdapter: PostersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postersBriefAdapter = PostersListAdapter(5, parentFragmentManager, lifecycle)
        binding.listEvent.adapter = postersBriefAdapter
    }

    private fun initObservers() {

    }

    private fun setPosters() {

    }

    private fun onPosterClicked(id: Int) {

    }
}