package com.example.theatre.features.poster.presentation.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theatre.databinding.FragmentPosterBinding
import com.example.theatre.features.poster.presentation.adapters.SectionPagerAdapter

/**
 * Фрагмент подробности постера (афиши)
 * Имеет адаптер [SectionPagerAdapter] с двумя фрагментами [PosterDescriptionFragment] и [PosterDetailFragment]
 *
 * @author Tamerlan Mamukhov on 2022-05-28
 * todo Исправить переходы между фрагментами. Добавить фрагмент описания и деталей (инфо и дет)
 *
 */
class PosterFragment : Fragment() {

    private lateinit var binding: FragmentPosterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPosterBinding.inflate(inflater, container, false)

        val viewPager = binding.viewPager
        viewPager.adapter = SectionPagerAdapter(requireActivity().supportFragmentManager, 0)

        val tabLayout = binding.tabs
        tabLayout.setupWithViewPager(viewPager)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPosterBinding.bind(view)
    }

}