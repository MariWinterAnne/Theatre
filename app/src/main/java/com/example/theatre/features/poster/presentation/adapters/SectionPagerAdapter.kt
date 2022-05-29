package com.example.theatre.features.poster.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.poster.presentation.ui.detail.PosterDescriptionFragment
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailFragment

/**
 * Класс-адаптер с двумя фрагментами [PosterDescriptionFragment] и [PosterDetailFragment]
 *
 * @property event
 * @constructor
 *
 *
 * todo Исправить имена фрагментов и прочее
 * @author Tamerlan Mamukhov on 2022-05-09
 */
class SectionPagerAdapter(
    fm: FragmentManager,
//    lifecycle: Lifecycle,
    private val event: Int
//) : FragmentStateAdapter(fm, lifecycle) {
) : FragmentStatePagerAdapter(fm) {

    private val items = arrayOf("Информация", "Детали")

    //
//    override fun getItemCount(): Int = items.size
//
//    override fun createFragment(position: Int): Fragment =
//        when (position) {
//            0 -> EventDescriptionFragment()
//            1 -> EventRatingFragment()
//            else -> {
//                EventRatingFragment()
//            }
//        }
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> PosterDescriptionFragment()
//                .newInstance(event)
            1 -> PosterDetailFragment()
//                .newInstance(event)
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = items[position]
}

/**
override fun getItem(position: Int): Fragment {
return when (position) {
0 -> EventDescriptionFragment()
1 -> EventRatingFragment()
else -> Fragment()
}
}

override fun getCount() = items.size

override fun getPageTitle(position: Int) = items[position]
 **/
