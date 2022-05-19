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

package com.example.theatre.features.spectacles.presentation.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.theatre.features.spectacles.presentation.ui.SpectacleViewModel
import com.example.theatre.features.spectacles.presentation.ui.detail.EventActivity
import com.example.theatre.features.spectacles.presentation.adapters.EventListAdapter
import com.example.theatre.R
import com.example.theatre.databinding.FragmentSpectaclesBinding
import com.example.theatre.features.spectacles.domain.model.Performance
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpectaclesFragment : Fragment() {

    private lateinit var binding: FragmentSpectaclesBinding
    private lateinit var performancesAdapter: EventListAdapter
    private lateinit var recyclerView: RecyclerView
    private val spectacleViewModel by viewModel<SpectacleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spectacles, container, false)

        recyclerView = view.findViewById(R.id.list_event) as RecyclerView
        performancesAdapter = EventListAdapter(mutableListOf()) { id ->
            onSpectacleClick(id)
        }
        recyclerView.adapter = performancesAdapter

        initObservers()

        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSpectaclesBinding.bind(view)
    }

    private fun initObservers() {
        spectacleViewModel.spectacleLoaded.observe(viewLifecycleOwner, ::setSpectacles)
    }

    private fun setSpectacles(performances: List<Performance>) {
        performancesAdapter.setSpectacles(performances)
    }

    private fun onSpectacleClick(id: Int) {
        val intent = Intent(activity, EventActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}
