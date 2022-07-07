package com.example.theatre.features.poster.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.poster.presentation.ui.detail.PosterDescriptionFragment
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment

/**
 * Адаптер для фрагмента афиши
 *
 * @author Tamerlan Mamukhov on 2022-07-07
 */
class SectionPagerAdapter(
    fm: FragmentManager,
    private val items: Array<String> = arrayOf(INFO, DETAILS)
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> PosterDescriptionFragment()
            DETAILS_TAB -> PosterDetailFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = items[position]

    companion object {
        private const val DESCRIPTION_TAB = 0
        private const val DETAILS_TAB = 1
        private const val INFO = "Информация"
        private const val DETAILS = "Детали"
    }
}