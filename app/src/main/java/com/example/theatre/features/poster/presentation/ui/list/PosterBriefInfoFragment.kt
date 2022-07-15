package com.example.theatre.features.poster.presentation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theatre.R
import com.example.theatre.databinding.FragmentPosterBriefInfoBinding

/**
 * Фрагмент с краткой информацией о постановке. Отображается в [PosterListFragment]
 *
 */
class PosterBriefInfoFragment : Fragment() {
    private lateinit var binding: FragmentPosterBriefInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poster_brief_info, container, false)
    }

}