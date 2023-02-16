package com.example.theatre.features.info.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.databinding.FragmentInfoBinding
import com.example.theatre.features.info.presentation.adapters.SectionPagerAdapter

/**
 * Фрагмент с вкладками, отображающими список театров и список актеров
 *
 * @author Tamerlan Mamukhov
 */

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)

        val viewPager = binding.viewPager
        viewPager.adapter = SectionPagerAdapter(childFragmentManager)

        val tabLayout = binding.tabs
        tabLayout.setupWithViewPager(viewPager)
    }
}