package com.example.theatre.features.spectacles.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.spectacles.presentation.ui.detail.EventDescriptionFragment
import com.example.theatre.features.spectacles.presentation.ui.detail.EventDescriptionFragment.Companion.DESCRIPTION_TAB
import com.example.theatre.features.spectacles.presentation.ui.detail.EventDescriptionFragment.Companion.INFO
import com.example.theatre.features.spectacles.presentation.ui.detail.ReviewFragment
import com.example.theatre.features.spectacles.presentation.ui.detail.ReviewFragment.Companion.DETAILS
import com.example.theatre.features.spectacles.presentation.ui.detail.ReviewFragment.Companion.DETAILS_TAB

/**
 * Адаптер для списка фрагментов
 *
 * @property items - названия вкладок
 *
 * @author Marianna Sabanchieva
 */

class SectionPagerAdapter(fm: FragmentManager, private val items: Array<String> = arrayOf(INFO, DETAILS)) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> EventDescriptionFragment.newInstance()
            DETAILS_TAB -> ReviewFragment.newInstance()
            else -> Fragment()
    }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
