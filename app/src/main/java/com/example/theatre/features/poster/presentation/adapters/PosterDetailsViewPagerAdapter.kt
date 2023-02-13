package com.example.theatre.features.poster.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * ViewPager фрагмент контента.
 * Использует фрагменты и создает их
 *
 * @param fragments     список фрагментов
 * @param fm            [FragmentManager]
 * @param lifecycle     [Lifecycle]
 * @author Tamerlan Mamukhov on 2022-07-07
 */
class PosterDetailsViewPagerAdapter(
    private val fragments: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}