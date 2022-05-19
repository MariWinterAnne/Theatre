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

package com.example.theatre.features.spectacles.presentation.ui.detail

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
import com.example.theatre.features.info.data.network.net.RetrofitClient
import com.example.theatre.features.spectacles.presentation.utils.DateUtils
import com.example.theatre.features.spectacles.presentation.ui.SpectacleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReviewFragment : Fragment() {

    companion object {
        fun newInstance(): ReviewFragment {
            return ReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by viewModel<SpectacleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_review, container, false)

        val bundle = activity?.intent?.extras
        val eventId = bundle?.getInt("id")

        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val results = eventId?.let { RetrofitClient.retrofit.getPerformanceById(it) }
                val place = results?.place?.id?.let { RetrofitClient.retrofit.getPlaceById(it) }
                val city = place?.location?.let { RetrofitClient.retrofit.getCityName(it) }

                with(binding) {
                    textDatetime.text = getString(R.string.event_date_time)
                    textPlace.text = getString(R.string.place)
                    textParticipants.text = getString(R.string.actors)
                    if (results?.dates != null) {
                        with(results) {
                            textAgeRestriction.text = age_restriction
                            for (i in 0 until dates.size) {
                                val startDate = dates[i].start!!.toLong()*1000
                                if(startDate >= DateUtils.currentTimeToLong()) {
                                    textEventStartEnd.append(DateUtils.convertLongToTime(dates[i].start!!, dates[i].end!!) + "\n")
                                }
                            }
                            var role = ""
                            for(i in 0 until participants.size) {
                                when (participants[i].role?.slug) {
                                    "actors" -> { role = "Актер" }
                                    "director" -> { role = "Режиссер" }
                                    "musician" -> { role = "Музыкант" }
                                    "screenwriter" -> { role = "Сценарист" }
                                    "stage-theatre" -> { role = "Театр-постановщик" }
                                }
                                textParticipantsList.append(participants[i].agent?.title + getString(R.string.gaps) + role + "\n")
                            }
                        }
                    }
                    if (place != null) {
                        with(place) {
                            textPlaceTitle.text =
                                this.title?.replaceFirstChar { it.uppercaseChar() }
                            textPlaceSubway.text = this.subway ?: ""
                            ((city?.name + getString(R.string.gaps)).plus(this.address ?: "")).also {
                                textPlaceAddress.text = it
                            }
                            (getString(R.string.tel).plus(this.phone ?: "")).also {
                                textPlacePhone.text = it
                            }
                            (getString(R.string.website).plus(this.foreignUrl ?: "")).also {
                                textPlaceSite.text = it
                            }
                            if (this.isClosed == true) {
                                textPlaceIsclosed.text = getString(R.string.place_is_closed)
                            }
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
