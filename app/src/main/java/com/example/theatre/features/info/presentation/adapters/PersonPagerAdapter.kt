/*
 * Copyright (c) 2018. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.theatre.features.info.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDescriptionFragment
import com.example.theatre.features.info.presentation.ui.detail.person.PersonReviewFragment
//TODO items в конструктор
class PersonPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val items = arrayOf("Информация", "Детали")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PersonDescriptionFragment.newInstance() //TODO числа вынести в const/enum/sealed classes
            1 -> PersonReviewFragment.newInstance()
            else -> Fragment()
        }
    }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position]
}
