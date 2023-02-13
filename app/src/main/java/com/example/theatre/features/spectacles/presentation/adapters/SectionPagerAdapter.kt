package com.example.theatre.features.spectacles.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsDescriptionFragment
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsDescriptionFragment.Companion.DESCRIPTION_TAB
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsDescriptionFragment.Companion.INFO
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleReviewFragment
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleReviewFragment.Companion.DETAILS
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleReviewFragment.Companion.DETAILS_TAB

/**
 * Адаптер для списка фрагментов
 *
 * @property items - названия вкладок
 *
 * @author Tamerlan Mamukhov
 */

class SectionPagerAdapter(fm: FragmentManager, private val items: Array<String> = arrayOf(INFO, DETAILS)) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> SpectacleDetailsDescriptionFragment.newInstance()
            DETAILS_TAB -> SpectacleReviewFragment.newInstance()
            else -> Fragment()
        }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
