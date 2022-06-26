package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPosterListBinding

/**
 * Фрагмент с ViewPager для отображения фраментов с кратким описанием постановок [PosterBriefInfoFragment]
 * @author Tamerlan Mamukhov on 2022-06-26
 */
class PosterListFragment : Fragment() {
    private lateinit var binding: FragmentPosterListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPosterListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}