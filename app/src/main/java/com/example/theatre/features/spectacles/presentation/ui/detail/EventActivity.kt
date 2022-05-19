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

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.theatre.R
import com.example.theatre.databinding.ActivityEventBinding
import com.example.theatre.features.info.data.network.net.RetrofitClient
import com.example.theatre.features.spectacles.presentation.adapters.SectionPagerAdapter
import com.example.theatre.features.spectacles.presentation.ui.SpectacleViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventActivity : AppCompatActivity() {

    lateinit var binding: ActivityEventBinding
    private val spectacleViewModel by viewModel<SpectacleViewModel>()
    private var eventURL: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        val eventId = bundle?.getInt("id")
        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val results = eventId?.let { RetrofitClient.retrofit.getPerformanceById(it) }
                val place = results?.place?.id?.let { RetrofitClient.retrofit.getPlaceById(it) }
                val city = place?.location?.let { RetrofitClient.retrofit.getCityName(it) }

                eventURL = results?.site_url

                with(binding.content) {
                    textName.text =
                        results?.short_title?.replaceFirstChar { it.uppercaseChar() }
                    if (results?.is_free == true) {
                        textPrice.text = "бесплатно"
                    } else {
                        textPrice.text = results?.price
                    }
                    Picasso.get()
                        .load(results?.images?.get(0)?.image.toString())
                        .into(imageThumbnail)
                    Picasso.get()
                        .load(results?.images?.get(0)?.image.toString())
                        .into(binding.imageLarge)
                    textVenue.text = city?.name
                }
            } catch (e: Throwable) {
                Toast.makeText(
                    baseContext,
                    "Ошибка получения данных.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val viewPager = binding.content.viewPager
        viewPager.adapter = eventId?.let { SectionPagerAdapter(supportFragmentManager) }

        val tabLayout = binding.content.tabs
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_event, menu)
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> finish()
            R.id.action_event -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(eventURL))
                startActivity(browserIntent)
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
