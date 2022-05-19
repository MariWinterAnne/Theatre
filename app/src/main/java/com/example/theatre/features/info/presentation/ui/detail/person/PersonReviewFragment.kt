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

package com.example.theatre.features.info.presentation.ui.detail.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.theatre.R
import com.example.theatre.databinding.FragmentReviewBinding
import com.example.theatre.features.info.presentation.ui.list.person.PersonViewModel

import com.example.theatre.features.info.data.network.net.RetrofitClient
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonReviewFragment : Fragment() {

    companion object {
        fun newInstance(): PersonReviewFragment {
            return PersonReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by viewModel<PersonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_review, container, false)

        val bundle = activity?.intent?.extras
        val personId = bundle?.getInt("person_id")

        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val persons = personId?.let { RetrofitClient.retrofit.getPersonById(it) }

                with(binding) {
                    textDatetime.text = getString(R.string.person_participations)
                    var role = ""
                    with(persons) {
                        for (i in 0 until this?.participations?.size!!) {
                            // slug -> getString(RoleType.resId)
                            when (participations[i].role?.slug) {
                                "actors" -> { role = "Актеры" }
                                "director" -> { role = "Режиссеры" }
                                "musician" -> { role = "Музыканты" }
                                "screenwriter" -> { role = "Сценаристы" }
                                "stage-theatre" -> { role = "Театры-постановщики" }
                            }
                            textEventStartEnd.append(role + getString(
                                R.string.dash) + participations[i].item?.title?.replaceFirstChar { it.uppercaseChar() } + "\n\n")
                        }
                    }
                }
            } catch (e: Throwable) {
                Toast.makeText(
                    context,
                    "Ошибка получения данных.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }

}
