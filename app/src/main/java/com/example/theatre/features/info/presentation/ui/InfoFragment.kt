package com.example.theatre.features.info.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theatre.databinding.FragmentInfoBinding
import com.example.theatre.features.info.presentation.adapters.SectionPagerAdapter

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)

        val viewPager = binding.viewPager
        viewPager.adapter = SectionPagerAdapter(requireActivity().supportFragmentManager)

        val tabLayout = binding.tabs
        tabLayout.setupWithViewPager(viewPager)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
    }

}