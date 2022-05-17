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
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.theatre.R
import com.example.theatre.databinding.FragmentEventDescriptionBinding
import com.example.theatre.features.info.presentation.ui.list.theatre.TheatreViewModel
import com.example.theatre.network.net.RetrofitClient
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class TheatreDescriptionFragment : Fragment() {

    companion object {

        fun newInstance(): TheatreDescriptionFragment {
            return TheatreDescriptionFragment()
        }
    }

    private lateinit var binding: FragmentEventDescriptionBinding
    private val spectacleViewModel by viewModel<TheatreViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_description, container, false)

        val bundle = activity?.intent?.extras
        val theatreId = bundle?.getInt("theatre_id")

        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val theatres = theatreId?.let { RetrofitClient.retrofit.getTheatreById(it) }

                with(binding) {
                    Picasso.get()
                        .load(theatres?.images?.get(0)?.image.toString())
                        .into(imageThumbnail)
                    textName?.text =
                        theatres?.title?.replaceFirstChar { it.uppercaseChar() }
                    textDescription.text =
                        theatres?.description?.let {
                            HtmlCompat.fromHtml(it,
                                HtmlCompat.FROM_HTML_MODE_LEGACY)
                        }
                    theatres?.bodyText?.let {
                        webView?.loadDataWithBaseURL(null,
                            it,"text/html","UTF-8","about:blank")
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
