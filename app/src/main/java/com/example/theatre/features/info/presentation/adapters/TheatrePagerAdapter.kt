package com.example.theatre.features.info.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDescriptionFragment
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDescriptionFragment.Companion.DESCRIPTION_TAB
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDescriptionFragment.Companion.INFO
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreReviewFragment
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreReviewFragment.Companion.DETAILS
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreReviewFragment.Companion.DETAILS_TAB

/**
 * Адаптер для списка фрагментов
 *
 * @property items - названия вкладок
 * @author Tamerlan Mamukhov
 */

class TheatrePagerAdapter(
    fm: FragmentManager,
    private val items: Array<String> = arrayOf(INFO, DETAILS)
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> TheatreDescriptionFragment.newInstance()
            DETAILS_TAB -> TheatreReviewFragment.newInstance()
            else -> Fragment()
        }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
