package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPosterDescriptionBinding

/**
 * Фрагмент описания афиши
 * @author Tamerlan Mamukhov on 2022-05-28
 */
class PosterDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentPosterDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosterDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }
}