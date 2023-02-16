package com.example.theatre.features.info.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDescriptionFragment
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDescriptionFragment.Companion.DESCRIPTION_TAB
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDescriptionFragment.Companion.INFO
import com.example.theatre.features.info.presentation.ui.detail.person.PersonReviewFragment
import com.example.theatre.features.info.presentation.ui.detail.person.PersonReviewFragment.Companion.DETAILS
import com.example.theatre.features.info.presentation.ui.detail.person.PersonReviewFragment.Companion.DETAILS_TAB

/**
 * Адаптер для списка фрагментов
 *
 * @property items - названия вкладок
 * @author Tamerlan Mamukhov
 */

class PersonPagerAdapter(
    fm: FragmentManager,
    private val items: Array<String> = arrayOf(INFO, DETAILS)
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> PersonDescriptionFragment.newInstance()
            DETAILS_TAB -> PersonReviewFragment.newInstance()
            else -> Fragment()
        }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
