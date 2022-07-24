package com.example.theatre.features.info.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.info.presentation.ui.list.person.PersonsFragment
import com.example.theatre.features.info.presentation.ui.list.person.PersonsFragment.Companion.DETAILS_TAB
import com.example.theatre.features.info.presentation.ui.list.person.PersonsFragment.Companion.PERSON
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatresFragment
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatresFragment.Companion.DESCRIPTION_TAB
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatresFragment.Companion.THEATRE

/**
 * Адаптер для списка фрагментов
 *
 * @property items - названия вкладок
 * @author Marianna Sabanchieva
 */

class SectionPagerAdapter(
    fm: FragmentManager,
    private val items: Array<String> = arrayOf(THEATRE, PERSON)
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment =
        when (position) {
            DESCRIPTION_TAB -> TheatresFragment.newInstance()
            DETAILS_TAB -> PersonsFragment.newInstance()
            else -> Fragment()
        }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
