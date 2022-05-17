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

package com.example.theatre.features.info.presentation.ui.detail.theatre

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
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatreViewModel
import com.example.theatre.network.net.RetrofitClient
import org.koin.androidx.viewmodel.ext.android.viewModel

class TheatreReviewFragment : Fragment() {

    companion object {
        fun newInstance(): TheatreReviewFragment {
            return TheatreReviewFragment()
        }
    }

    private lateinit var binding: FragmentReviewBinding
    private val spectacleViewModel by viewModel<TheatreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_review, container, false)

        val bundle = activity?.intent?.extras
        val theatreId = bundle?.getInt("theatre_id")

        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val theatres = theatreId?.let { RetrofitClient.retrofit.getTheatreById(it) }
                val city = theatres?.location?.let { RetrofitClient.retrofit.getCityName(it) }

                with(binding){
                    textDatetime.text = getString(R.string.theatre_schedule)
                    textPlace.text = getString(R.string.theatre_address)
                    textEventStartEnd.text = theatres?.timetable
                    textPlaceTitle.text = theatres?.title?.replaceFirstChar { it.uppercaseChar() }
                    textPlaceSubway.text = theatres?.subway
                    ((city?.name + getString(R.string.gaps)).plus(theatres?.address)).also {
                        textPlaceAddress.text = it
                    }
                    (getString(R.string.tel).plus(theatres?.phone)).also {
                        textPlacePhone.text = it
                    }
                    (getString(R.string.website).plus(theatres?.foreignUrl)).also {
                        textPlaceSite.text = it
                    }
                    if (theatres?.isClosed == true) {
                        textPlaceIsclosed.text = getString(R.string.place_is_closed)
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
