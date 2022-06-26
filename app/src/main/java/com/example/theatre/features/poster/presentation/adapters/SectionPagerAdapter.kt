package com.example.theatre.features.poster.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.poster.presentation.ui.detail.PosterDescriptionFragment
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val items = arrayOf("Информация", "Детали")

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> PosterDescriptionFragment()
            1 -> PosterDetailFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = items[position]
}